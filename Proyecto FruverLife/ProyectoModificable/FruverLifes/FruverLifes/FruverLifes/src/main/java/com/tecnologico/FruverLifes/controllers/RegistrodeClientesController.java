
package com.tecnologico.FruverLifes.controllers;

import com.tecnologico.FruverLifes.Service.GestorClientesService;
import com.tecnologico.FruverLifes.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Cliente")
public class RegistrodeClientesController {

    @Autowired
    private GestorClientesService gestorClientesService;

    @PostMapping("/registrocli")
    public String procesarRegistro(Clientes cliente) {

        gestorClientesService.registrarclientess(cliente);

        return "redirect:/Cliente";
    }

    @GetMapping
    public String listarClientes(Model model) {

        model.addAttribute("clientes", gestorClientesService.listars());

        return "MenuCajero";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable long id) {

        gestorClientesService.eliminar(id);

        return "redirect:/Cliente";
    }
}