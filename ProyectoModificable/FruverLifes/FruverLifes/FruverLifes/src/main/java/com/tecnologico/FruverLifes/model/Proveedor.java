package com.tecnologico.FruverLifes.model;

import jakarta.persistence.*;
@Entity
@Table(name = "proveedores")
public class Proveedor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_proveedores")
        private int id;

        @Column(name = "NIT")
        private String nit;

        private String nombre;

        private String numero;

        private String correo;

        public Proveedor() {}

        public Proveedor(int id, String nit, String nombre, String numero, String correo) {
            this.id = id;
            this.nit = nit;
            this.nombre = nombre;
            this.numero = numero;
            this.correo = correo;
        }

        // getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNit() {
            return nit;
        }

        public void setNit(String nit) {
            this.nit = nit;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }
}
