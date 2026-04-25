package com.tecnologico.FruverLifes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "usuario", nullable = false, unique = true)
    private String usuario;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia, String cargo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
    }

    public Long getIdUsuario() {

        return idUsuario;
    }

    public String getUsuario() {

        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getCargo() {

        return cargo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {

        this.contrasenia = contrasenia;
    }

    public void setCargo(String cargo) {

        this.cargo = cargo;
    }
}