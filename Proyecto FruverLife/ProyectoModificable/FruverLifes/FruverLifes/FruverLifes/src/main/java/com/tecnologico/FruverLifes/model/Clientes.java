package com.tecnologico.FruverLifes.model;

public class Clientes {

    private long id;
    private String nombre;
    private String numeroCe;
    private String correo;


    public Clientes() {
    }

    public Clientes(long id, String nombre, String numeroCe, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.numeroCe = numeroCe;
        this.correo = correo;
    }

    public long getId() {   // 👈 corregido (mayúscula)
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCe() {   // 👈 corregido
        return numeroCe;
    }

    public void setNumeroCe(String numeroCe) {
        this.numeroCe = numeroCe;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
