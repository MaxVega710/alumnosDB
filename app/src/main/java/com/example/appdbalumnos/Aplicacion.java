package com.example.appdbalumnos;


import android.app.Application;

import java.util.ArrayList;


import modelo.AlumnosDB;

public class Aplicacion extends Application {

    public static ArrayList<Alumno> alumnos;
    private AlumnosDB alumnoDB;

    public ArrayList<Alumno> getAlumnos(){
        return alumnos;

    }
    @Override
    public void onCreate(){
        super.onCreate();
        alumnoDB = new AlumnosDB(getApplicationContext());
        alumnos = alumnoDB.allAlumnos();

    }
}
