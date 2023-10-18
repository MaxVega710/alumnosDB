package com.example.appdbalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AltaAlumnoActivity extends AppCompatActivity {

    private Button btnLimpiar, btnGuardar, btnBorrar, btnRegresar;
    private Alumno alumno;
    private EditText txtNombre, txtMatricula, txtCarrera;
    private ImageView imgAlumno;
    private TextView lblFoto;
    private int posicion;
    private String urlFoto;

    public void iniciarObjetos(){
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnBorrar = findViewById(R.id.btnEliminar);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtNombre = findViewById(R.id.txtNombre);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCarrera = findViewById(R.id.txtCarrera);
        imgAlumno = findViewById(R.id.imgAlumno);
        lblFoto = findViewById(R.id.lblFoto);
    }

    private void cargarIMG(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_alumno);
        iniciarObjetos();
        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion");

        if(posicion >= 0) {
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtCarrera.setText(alumno.getCarrera());
            imgAlumno.setImageURI(Uri.parse(alumno.getImagen()));
        }
    }
}