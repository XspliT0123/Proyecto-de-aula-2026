package com.tecnologico.FruverLifes.services;
import com.tecnologico.FruverLifes.model.FruverLifemodel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruverLifeimplet implements FruverLifeservices{
    @Override
    public List<FruverLifemodel> listar() {
        FruverLifemodel  inventario = new  FruverLifemodel();
        inventario.setNombrePro("Banano");
        inventario.setCodigo (234);
        inventario.setCantidad(4);
        inventario.setPrecio(34000);

        FruverLifemodel inventario2= new FruverLifemodel();
        inventario2.setNombrePro("Sandia");
        inventario2.setCodigo (2343);
        inventario2.setCantidad(6);
        inventario2.setPrecio(31000);
        List<FruverLifemodel> lista= new ArrayList<>();
        lista.add(inventario);
        lista.add(inventario2);
        return lista;
    }
}
