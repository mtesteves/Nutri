package mx.com.nutriapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 8/30/16.
 */
public class CalculaIMC extends AppCompatActivity {


    private EditText altura, peso,resultadoIMC;
    private TextView valorIMC;
    private String StringAltura,StringPeso,StringIMC;
    private Button btnCalculas;
    public SQLiteDatabase db;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        altura = (EditText) findViewById(R.id.altura);
        peso = (EditText) findViewById(R.id.peso);
        valorIMC = (TextView) findViewById(R.id.valorIMC);
        btnCalculas = (Button) findViewById(R.id.calculaIMC);





        btnCalculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringAltura = altura.getText().toString();
                StringPeso = peso.getText().toString();
                StringIMC = valorIMC.getText().toString();

                if (validaDatos(StringAltura, StringPeso)) {
                    Log.d("Es true", "datos validos");
                    StringIMC = String.valueOf(calculaIMC(altura, peso));
                    hitTeclado();

                    //situacion(calculaIMC(altura, peso));
                    //Log.d("Es true", "Tu Situacion es :" + situacion(calculaIMC(altura, peso)));
                    Log.d("Es true", "Tu IMC es :" + calculaIMC(altura, peso));
                    valorIMC.setText("Tu IMC es: " + StringIMC);


                } else {
                    showAlert();
                    hitTeclado();
                }

            }
        });

    }

    public void hitTeclado(){
        InputMethodManager ocultarTeclado =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        ocultarTeclado.hideSoftInputFromWindow(btnCalculas.getWindowToken(), 0);
    }

    public void showAlert(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CalculaIMC.this);
        alertDialogBuilder.setMessage("Verifica los datos e intenta nuevamente")
                .setTitle("Aviso")
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

private float calculaIMC(EditText valor1 , EditText valor2){
        float altura = Float.parseFloat(valor1.getText().toString());
        float peso = Float.parseFloat(valor2.getText().toString());

        Float imc  = (float) ((peso)/(Math.pow(2,altura)));

        return imc;

    }


    boolean validaDatos (String alturaUno, String pesoUno){
        boolean valida = false;

        if( !(alturaUno.equals("")) && !(pesoUno.equals("")) ){
            if(alturaUno != null && pesoUno != null){

                valida = true;
            }


        }
        return valida;
    }
}
