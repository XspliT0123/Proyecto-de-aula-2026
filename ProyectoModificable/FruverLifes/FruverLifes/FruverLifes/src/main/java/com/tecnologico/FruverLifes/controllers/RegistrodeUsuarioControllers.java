package com.tecnologico.FruverLifes.controllers;
import com.tecnologico.FruverLifes.model.Usuario;
import com.tecnologico.FruverLifes.Service.GestorUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class RegistrodeUsuarioControllers {

    @Autowired
    private GestorUsuarioService gestorUsuarioService;

    @PostMapping("/registro")
    public Map<String, String> registrarUsuario(
            @RequestParam String nombreUsuario,
            @RequestParam String cargo,
            @RequestParam String contrasenia) {

        Map<String, String> respuesta = new HashMap<>();

        if (!cargo.equalsIgnoreCase("Gerente") &&
                !cargo.equalsIgnoreCase("Cajero") &&
                !cargo.equalsIgnoreCase("Administrador")) {

            respuesta.put("mensaje", "Cargo inválido");
            return respuesta;
        }

        try {
            Usuario usuario = new Usuario(nombreUsuario, contrasenia, cargo);
            gestorUsuarioService.registrarUsuarios(usuario);

            respuesta.put("mensaje", " Usuario registrado correctamente");

        } catch (Exception e) {
            respuesta.put("mensaje", "Error al registrar usuario");
        }

        return respuesta;
    }
}
