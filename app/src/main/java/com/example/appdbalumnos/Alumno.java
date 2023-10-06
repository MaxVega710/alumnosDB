package com.example.appdbalumnos;

import java.io.Serializable;

public class Alumno  implements Serializable {
    private int id;
    private String matricula;
    private String carrera;
    private String nombre;
    private String imagen;


    public Alumno() {


    }


    public Alumno(int id, String matricula, String carrera, String nombre, String imagen) {

        this.id = id;
        this.matricula = matricula;
        this.carrera = carrera;
        this.nombre = nombre;
        this.imagen = imagen;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Alumno(String matricula, String carrera, String nombre, String imagen) {
        this.matricula = matricula;
        this.carrera = carrera;
        this.nombre = nombre;
        this.imagen = imagen;
    }

}



