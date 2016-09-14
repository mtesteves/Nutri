package mx.com.nutriapp;

import android.content.ContentValues;
import mx.com.nutriapp.PacienteContact.PacienteEntry;

/**
 * Created by root on 9/5/16.
 */
public class Paciente {

    private String id;
    private String name;
    private String lastName;
    private String secondName;
    private String years;
    private String height;
    private String weight;
    private String IMC;
    private String diseases;
    private String lastVisit;

    public Paciente(String id, String name, String lastName, String secondName, String years){//, String height, String weight, String IMC, String diseases, String lastVisit){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.secondName = secondName;
        this.years = years;
        this.height = height;
        this.weight = weight;
        this.IMC = IMC;
        this.diseases = diseases;
        this.lastVisit = lastVisit;

    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSecondName(){
        return secondName;
    }
    public String getYears(){
        return years;
    }
    public String getHeight(){
        return height;
    }
    public String getWeight(){
        return weight;
    }
    public String getIMC(){
        return IMC;
    }
    public String getDiseases(){
        return diseases;
    }
    public String getLastVisit(){
        return lastVisit;
    }


    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PacienteEntry.ID,id);
        values.put(PacienteEntry.NAME,name);
        values.put(PacienteEntry.LAST_NAME,lastName);
        values.put(PacienteEntry.SECOND_NAME,secondName);
        values.put(PacienteEntry.YEARS,years);

        return values;

    }
}
