package mx.com.nutriapp;

import android.provider.BaseColumns;

/**
 * Created by root on 9/5/16.
 */
public class PacienteContact {

    public static abstract class PacienteEntry implements BaseColumns{
        public static final String TABLE_NAME = "paciente";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String LAST_NAME = "lastName";
        public static final String SECOND_NAME = "secondNaME";
        public static final String YEARS = "year";
        public static final String HEIGHT = "height";
        public static final String WEIGHT = "weight";
        public static final String IMC = "IMC";
        public static final String DISEASES = "diseases";
        public static final String LAST_VISIT = "lastVisit";
    }
}
