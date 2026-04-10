package com.tecnologico.FruverLifes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tecnologico.FruverLifes.Service.ProductoService;

@RestController

@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String inicio() {
        return "Menú de productos";
    }

    @GetMapping("/agregar")
    public String agregarProducto() {
        return productoService.agregarProducto();
    }

    @GetMapping("/eliminar")
    public String eliminarProducto() {
        return productoService.eliminarProducto();
    }

    @GetMapping("/modificar")
    public String modificarCantidad() {
        return productoService.modificarCantidad();
    }
}