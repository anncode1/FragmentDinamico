package com.anncode.mifragmentdinamico;

/**
 * Created by anahisalgado on 07/10/15.
 */
public class Persona {

    private String nombre;
    private String telefono;
    private String twitter;
    private String correo;
    private String foto;


    public Persona(String nombre, String telefono, String twitter, String correo, String foto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.twitter = twitter;
        this.correo = correo;
        this.foto = foto;
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

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
