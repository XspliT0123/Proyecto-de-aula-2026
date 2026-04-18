package com.tecnologico.FruverLifes.model;

import java.util.Map;

public class Cajero {

    private String usuario;
    private String cargo;

    private Map<String, Double> productos;

    public String getUsuario() {

        return usuario;
    }
    public void setUsuario(String usuario) {

        this.usuario = usuario;
    }

    public String getCargo() {

        return cargo;
    }
    public void setCargo(String cargo) {

        this.cargo = cargo;
    }

    public Map<String, Double> getProductos() {

        return productos;
    }
    public void setProductos(Map<String, Double> productos) {

        this.productos = productos;
    }
}