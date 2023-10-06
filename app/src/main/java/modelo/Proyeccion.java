package modelo;

import android.database.Cursor;

import com.example.appdbalumnos.Alumno;
import java.util.ArrayList;

public interface Proyeccion {
    long updateAlumno(Alumno alumno);

    public Alumno getAlumno(String matricula);
    public ArrayList<Alumno> allAlumnos();
    public Alumno readAlumno(Cursor cursor);

}
