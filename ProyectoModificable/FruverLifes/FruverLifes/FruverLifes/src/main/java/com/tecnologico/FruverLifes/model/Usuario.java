package com.tecnologico.FruverLifes.model;

public class Usuario{

    private  String usuario;
    private  String contrasenia;
    private String cargo;

    public Usuario() {
    }
    public Usuario(String usuario, String contrasenia, String cargo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
    }

    public String getContrasenia() {

        return contrasenia;
    }
    public String getUsuario(){

        return usuario;
    }
    public String getCargo(){
        return cargo;
    }

    public void setContrasenia(String contrasenia) {

        this.contrasenia = contrasenia;
    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;
    }

    public void setCargo(String cargo) {

        this.cargo = cargo;
    }
}
