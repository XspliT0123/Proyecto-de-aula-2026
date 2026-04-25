package com.tecnologico.FruverLifes.Service;

import com.tecnologico.FruverLifes.model.Producto;
import com.tecnologico.FruverLifes.repositories.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto guardar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public List<Producto> listar() {
        return productoRepositorio.findAll();
    }

    public Optional<Producto> buscarPorId(int id) {
        return productoRepositorio.findById(id);
    }

    public void eliminar(int id) {
        productoRepositorio.deleteById(id);
    }
}