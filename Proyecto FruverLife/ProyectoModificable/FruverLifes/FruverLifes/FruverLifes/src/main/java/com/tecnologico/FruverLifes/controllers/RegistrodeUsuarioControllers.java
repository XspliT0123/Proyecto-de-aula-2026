package com.tecnologico.FruverLifes.controllers;

import com.tecnologico.FruverLifes.model.Usuario;
import com.tecnologico.FruverLifes.Service.GestorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class RegistrodeUsuarioControllers {

    @Autowired
    private GestorUsuarioService gestorUsuarioService;

    @PostMapping("/registro")
    public String procesarRegistro(
            @RequestParam String nombreUsuario,

            @RequestParam String cargo,

            @RequestParam String contrasenia) {

        if (!cargo.equalsIgnoreCase("Gerente") && !cargo.equalsIgnoreCase("Cajero")  && !cargo.equalsIgnoreCase("Administrador")) {
            return "Cargo inválido.";
        }

        Usuario usuario = new Usuario(nombreUsuario, contrasenia, cargo);

        gestorUsuarioService.registrarUsuarios(usuario);

        return "Usuario registrado correctamente";
    }
}
