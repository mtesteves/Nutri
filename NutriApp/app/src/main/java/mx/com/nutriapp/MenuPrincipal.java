package mx.com.nutriapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 8/30/16.
 */
public class MenuPrincipal extends AppCompatActivity {

    private Button btnIMC;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        btnIMC = (Button) findViewById(R.id.btnIMC);
        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this,CalculaIMC.class);
                startActivity(intent);
            }
        });

    }
}
