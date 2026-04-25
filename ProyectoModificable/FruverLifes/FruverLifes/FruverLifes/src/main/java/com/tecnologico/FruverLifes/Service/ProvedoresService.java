package com.tecnologico.FruverLifes.Service;

import com.tecnologico.FruverLifes.model.Proveedor;
import com.tecnologico.FruverLifes.repositories.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvedoresService {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    public Proveedor guardar(Proveedor p) {
        return proveedorRepositorio.save(p);
    }

    public List<Proveedor> listar() {
        return proveedorRepositorio.findAll();
    }

    public void eliminar(int id) {
        proveedorRepositorio.deleteById(id);
    }
}
