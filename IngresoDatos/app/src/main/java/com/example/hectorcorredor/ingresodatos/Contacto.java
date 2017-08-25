package com.example.hectorcorredor.ingresodatos;

/**
 * Created by hector.corredor on 23/08/2017.
 */

public class Contacto {

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descrip;


    public Contacto() {
    }

    public Contacto(String nombre, String fecha ,String telefono, String email, String descrip) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.telefono = telefono;
        this.email = email;
        this.descrip = descrip;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
