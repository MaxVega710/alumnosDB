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
        ContentValues values = new ContentValues();
        values.put(DefineTable.Alumnos.COLUMN_NAME_MATRICULA,alumno.getMatricula());
        values.put(DefineTable.Alumnos.COLUMN_NAME_NOMBRE,alumno.getNombre());
        values.put(DefineTable.Alumnos.COLUMN_NAME_CARRERA,alumno.getCarrera());
        values.put(DefineTable.Alumnos.COLUMN_NAME_FOTO,alumno.getImagen());

        this.openDataBase();
        long num = sqLiteDatabase.update(DefineTable.Alumnos.TABLE_NAME,
                values,
                DefineTable.Alumnos.COLUMN_NAME_ID +"=" + alumno.getId(),null);

        this.closeDataBase();
        Log.d("modificar", "se modifico el id"+alumno.getId());
        return num;

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
        sqLiteDatabase =helper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(DefineTable.Alumnos.TABLE_NAME,DefineTable.Alumnos.REGISTRO,
                DefineTable.Alumnos.COLUMN_NAME_MATRICULA + "=?",
                new String[]{matricula},null,null,null);
        cursor.moveToFirst();
        Alumno alumno = readAlumno(cursor);
        cursor.close();
        return alumno;
    }

    @Override
    public ArrayList<Alumno> allAlumnos() {
        sqLiteDatabase = helper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(DefineTable.Alumnos.TABLE_NAME,DefineTable.Alumnos.REGISTRO,
                null,null,null,null,null);
        cursor.moveToFirst();
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        while (!cursor.isAfterLast()){

            Alumno alumno = readAlumno(cursor);
            alumnos.add(alumno);
            cursor.moveToNext();

        }
        cursor.close();
        return alumnos;
    }

    @Override
    public Alumno readAlumno(Cursor cursor) {
        Alumno alumno = new Alumno();
        alumno.setId(cursor.getInt(0));
        alumno.setMatricula(cursor.getString(1));
        alumno.setNombre(cursor.getString(2));
        alumno.setCarrera(cursor.getString(3));
        alumno.setImagen(cursor.getString(4));
        return alumno;

    }
}
