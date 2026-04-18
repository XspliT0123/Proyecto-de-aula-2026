package com.tecnologico.FruverLifes.Service;

import org.springframework.stereotype.Service;
import com.tecnologico.FruverLifes.model.Producto;

@Service
public class ProductoService {

    public String agregarProducto() {
        Producto p = new Producto(0, null, 0, 0);
        p.RegistrarProducto();
        return "Producto agregado correctamente";
    }

    public String eliminarProducto() {
        Producto p = new Producto(0, null, 0, 0);
        p.eliminarProducto();
        return "Producto eliminado correctamente";
    }

    public String modificarCantidad() {
        Producto p = new Producto(0, null, 0, 0);
        p.ModificarCantidadProducto();
        return "Cantidad modificada correctamente";
    }
}