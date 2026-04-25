package com.tecnologico.FruverLifes.repositories;

import com.tecnologico.FruverLifes.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {

}