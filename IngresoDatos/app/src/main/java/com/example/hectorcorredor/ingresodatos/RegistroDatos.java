package com.example.hectorcorredor.ingresodatos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class RegistroDatos extends AppCompatActivity {

    private TextInputLayout CNombre;
    private TextInputLayout CTelefono;
    private TextInputLayout CMail;
    private TextInputLayout CDescrip;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_datos);
        CNombre = (TextInputLayout) findViewById(R.id.CNombre);

        //Fecha
        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);


        CTelefono = (TextInputLayout) findViewById(R.id.CTelefono);
        CMail = (TextInputLayout) findViewById(R.id.CMail);
        CDescrip = (TextInputLayout) findViewById(R.id.CDescrip);

        // Referencia Botón
        Button botonAceptar = (Button) findViewById(R.id.Cbutton);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });
    }

    private boolean esNombreValido(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
            CNombre.setError("Nombre inválido");
            return false;
        } else {
            CNombre.setError(null);
        }

        return true;
    }

    private void validarDatos() {
        //dateView = (TextView) findViewById(R.id.textView3);
        String nombre = CNombre.getEditText().getText().toString();
        String fecha = dateView.getText().toString();
        String telefono = CTelefono.getEditText().getText().toString();
        String email = CMail.getEditText().getText().toString();
        String descrip = CDescrip.getEditText().getText().toString();
        boolean a = esNombreValido(nombre);
        if (a) {
            Intent i = new Intent (RegistroDatos.this, ValidarDatos.class);
            Contacto contacto = new Contacto(nombre, fecha,telefono, email, descrip);
            i.putExtra("nombre", contacto.getNombre());
            i.putExtra("fecha", contacto.getFecha());
            i.putExtra("telefono", contacto.getTelefono());
            i.putExtra("email", contacto.getEmail());
            i.putExtra("descrip", contacto.getDescrip());
            startActivity(i);
         }

    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }
}
