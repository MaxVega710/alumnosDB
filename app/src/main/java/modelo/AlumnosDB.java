package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appdbalumnos.Alumno;

import java.util.ArrayList;

public class AlumnosDB implements Persistencia, Proyeccion{
    private Context context;
    private AlumnosDbHelper helper;
    private SQLiteDatabase sqLiteDatabase;

    public AlumnosDB(Context context) {
        this.context = context;
    }

    public AlumnosDB(Context context, AlumnosDbHelper helper) {
        this.helper = helper;
        this.context = context;

    }

    @Override
    public void openDataBase() {
        sqLiteDatabase = helper.getWritableDatabase();
    }

    @Override
    public void closeDataBase() {
    helper.close();
    }

    @Override
    public long insertAlumno(Alumno alumno) {
        ContentValues values = new ContentValues();
        values.put(DefineTable.Alumnos.COLUMN_NAME_MATRICULA, alumno.getMatricula());
        values.put(DefineTable.Alumnos.COLUMN_NAME_NOMBRE, alumno.getNombre());
        values.put(DefineTable.Alumnos.COLUMN_NAME_CARRERA, alumno.getCarrera());
        values.put(DefineTable.Alumnos.COLUMN_NAME_FOTO, alumno.getImagen());

        this.openDataBase();
        long num = sqLiteDatabase.insert(DefineTable.Alumnos.TABLE_NAME, null, values);
        this.closeDataBase();
        Log.d("Alumnos ", "Se agrego registro " + num);

        return num;
    }

    @Override
    public long updateAlumno(Alumno alumno) {
        return 0;
    }

    @Override
    public void deleteAlumnos(int id) {
        this.openDataBase();
        sqLiteDatabase.delete(DefineTable.Alumnos.TABLE_NAME,DefineTable.Alumnos.COLUMN_NAME_ID + "=?",
                new String[]{String.valueOf(id)});

        this.closeDataBase();

    }

    @Override
    public Alumno getAlumno(String matricula) {
        return null;
    }

    @Override
    public ArrayList<Alumno> allAlumnos() {
        return null;
    }

    @Override
    public Alumno readAlumno(Cursor cursor) {
        return null;
    }
}
