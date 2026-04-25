package com.tecnologico.FruverLifes.controllers;

import com.tecnologico.FruverLifes.Service.GestorUsuarioService;
import com.tecnologico.FruverLifes.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class RegistrodeUsuarioControllers {

    @Autowired
    private GestorUsuarioService gestorUsuarioService;

    @GetMapping("/registro")
    public String registrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/registro";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam String usuario,
                          @RequestParam String contrasenia,
                          @RequestParam String cargo,
                          Model model) {

        if (!cargo.equalsIgnoreCase("Gerente") &&
                !cargo.equalsIgnoreCase("Cajero") &&
                !cargo.equalsIgnoreCase("Administrador")) {

            model.addAttribute("error", "Cargo inválido");
            return "usuarios/registro";
        }

        if (gestorUsuarioService.buscarPorUsuario(usuario).isPresent()) {
            model.addAttribute("error", "El usuario ya existe");
            return "usuarios/registro";
        }

        try {
            Usuario nuevo = new Usuario();
            nuevo.setUsuario(usuario);
            nuevo.setContrasenia(contrasenia);
            nuevo.setCargo(cargo);

            gestorUsuarioService.registrarUsuarios(nuevo);

            model.addAttribute("success", "Usuario registrado correctamente");
            return "usuarios/registro";

        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar");
            return "usuarios/registro";
        }
    }
}
