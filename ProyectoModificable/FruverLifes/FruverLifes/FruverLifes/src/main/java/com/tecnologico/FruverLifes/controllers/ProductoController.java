package com.tecnologico.FruverLifes.controllers;

import com.tecnologico.FruverLifes.model.Producto;
import com.tecnologico.FruverLifes.model.Proveedor;
import com.tecnologico.FruverLifes.repositories.ProveedorRepositorio;
import com.tecnologico.FruverLifes.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorRepositorio proveedorRepository;

    @PostMapping("/guardar")
    public String guardar(@RequestParam String nombre,
                          @RequestParam double precio,
                          @RequestParam int cantidad,
                          @RequestParam int idProveedor) {

        Proveedor proveedor = proveedorRepository.findById(idProveedor)
                .orElse(null);

        if (proveedor == null) {
            return "Proveedor no encontrado";
        }

        Producto p = new Producto();
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setCantidad(cantidad);
        p.setProveedor(proveedor);

        productoService.guardar(p);

        return "Producto guardado correctamente";
    }
}