package com.example.hectorcorredor.ingresodatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ValidarDatos extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_datos);
        TextView nombre = (TextView)findViewById(R.id.VNombre);
        String nombre1 = getIntent().getStringExtra("nombre");
        nombre.setText("Nombre Completo: " + nombre1);
        TextView fecha = (TextView)findViewById(R.id.VFecha);
        String fecha1 = getIntent().getStringExtra("fecha");
        fecha.setText("Fecha de Nacimiento: " + fecha1);
        TextView telefono = (TextView)findViewById(R.id.VTelefono);
        String telefono1 = getIntent().getStringExtra("telefono");
        telefono.setText("Telefono: " + telefono1);
        TextView email = (TextView)findViewById(R.id.VEmail);
        String email1 = getIntent().getStringExtra("email");
        email.setText("Email: " + email1);
        TextView descrip = (TextView)findViewById(R.id.VDescrip);
        String descrip1 = getIntent().getStringExtra("descrip");
        descrip.setText("Descripción del contacto: " + descrip1);

        Button botonedit = (Button) findViewById(R.id.VButone);
        botonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
