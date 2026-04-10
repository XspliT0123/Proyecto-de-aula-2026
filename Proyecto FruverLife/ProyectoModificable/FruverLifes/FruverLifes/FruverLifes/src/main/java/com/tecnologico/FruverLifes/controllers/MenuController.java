package com.tecnologico.FruverLifes.controllers;
import com.tecnologico.FruverLifes.Service.InicioSesionService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/gerente")
      public String menuG() {

        return "MenuGerente";
    }
    @GetMapping("/Administrador")
    public String menuA() {

        return "MenuAdmi";
    }
    @GetMapping("/Cajero")
     public String menuC() {

        return "MenuCajero";
    }


}