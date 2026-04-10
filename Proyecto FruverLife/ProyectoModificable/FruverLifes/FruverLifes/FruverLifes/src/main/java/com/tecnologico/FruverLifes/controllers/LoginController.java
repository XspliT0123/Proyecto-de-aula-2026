package com.tecnologico.FruverLifes.controllers;

import com.tecnologico.FruverLifes.Service.CargoService;
import com.tecnologico.FruverLifes.Service.GestorUsuarioService;
import com.tecnologico.FruverLifes.Service.InicioSesionService;
import com.tecnologico.FruverLifes.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private InicioSesionService inicioSesionService;
    @Autowired
    private CargoService cargoService;

    @GetMapping("/login")
    public String mostrarLogin() {

        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute Usuario request) {
        boolean valido = inicioSesionService.verificarUsuario(
                request.getUsuario(),
                request.getContrasenia()
        );

        if (valido) {
            String cargo = cargoService.obtenerCargo(request.getUsuario());
            if (cargo != null && cargo.equalsIgnoreCase("Gerente")) {
                return "redirect:/menu/gerente";

            } else if (cargo != null && cargo.equalsIgnoreCase("Administrador")) {
                return "redirect:/menu/Administrador";
            } else  {
                return "redirect:/menu/Cajero";
            }
        } else {
            return "login";
        }
    }
}
