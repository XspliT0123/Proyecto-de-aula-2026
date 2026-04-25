package com.tecnologico.FruverLifes.controllers;

import com.tecnologico.FruverLifes.Service.ProvedoresService;
import com.tecnologico.FruverLifes.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class ProvedoresControllers {

    @Autowired
    private ProvedoresService proveedorService;

    @PostMapping("/guardar")
    public String guardar(@RequestParam String nit,
                          @RequestParam String nombre,
                          @RequestParam String numero,
                          @RequestParam String correo) {

        Proveedor p = new Proveedor();
        p.setNit(nit);
        p.setNombre(nombre);
        p.setNumero(numero);
        p.setCorreo(correo);

        proveedorService.guardar(p);


        return "redirect:/admin";

    }
}
