package mx.com.nutriapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import mx.com.nutriapp.PacienteContact.PacienteEntry;

/**
 * Created by root on 9/5/16.
 */
public class PacienteDbHelp extends SQLiteOpenHelper {

    public static final  int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pacientes.db";

    public PacienteDbHelp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + PacienteEntry.TABLE_NAME + " ("
                + PacienteEntry.ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PacienteEntry.ID + "TEXT NOT NULL,"
                + PacienteEntry.NAME + "TEXT NOT NULL,"
                + PacienteEntry.LAST_NAME + "TEXT NOT NULL,"
                + PacienteEntry.SECOND_NAME + "TEXT NOT NULL,"
                + PacienteEntry.YEARS + "TEXT NOT NULL,"
                + PacienteEntry.HEIGHT + "TEXT NOT NULL,"
                + PacienteEntry.WEIGHT + "TEXT NOT NULL,"
                + PacienteEntry.IMC + "TEXT NOT NULL,"
                + PacienteEntry.DISEASES + "TEXT NOT NULL,"
                + PacienteEntry.LAST_VISIT + "TEXT NOT NULL,"
                + "UNIQUE (" + PacienteEntry.ID + "))");

        mockData(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockLawyer(sqLiteDatabase, new Paciente("Carlos Perez", "Perez",
                "300 200 1111", "Gran profesional con experie",
                "carlos_perez"));
    }

    public long mockLawyer(SQLiteDatabase db, Paciente lawyer) {
        return db.insert(
                PacienteContact.PacienteEntry.TABLE_NAME,
                null,
                lawyer.toContentValues());
    }


    public long savePacientes(Paciente paciente){
        SQLiteDatabase sqLiteDatabase =  getWritableDatabase();

        return sqLiteDatabase.insert(PacienteEntry.TABLE_NAME,null,paciente.toContentValues());
    }
}
