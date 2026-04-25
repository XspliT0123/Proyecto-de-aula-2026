package com.tecnologico.FruverLifes.controllers;
import com.tecnologico.FruverLifes.Service.GestorUsuarioService;
import com.tecnologico.FruverLifes.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private GestorUsuarioService gestorUsuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String contrasenia,
                        HttpSession session) {

        Optional<Usuario> userOpt = gestorUsuarioService.buscarPorUsuario(usuario);

        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();

            if (user.getContrasenia().equals(contrasenia)) {

                session.setAttribute("usuarioLogueado", user);

                if (user.getCargo().equalsIgnoreCase("Gerente")) {
                    return "redirect:/menu/gerente";

                } else if (user.getCargo().equalsIgnoreCase("Administrador")) {
                    return "redirect:/menu/Administrador";

                } else {
                    return "redirect:/menu/Cajero";
                }
            }
        }

        return "login";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }

    @GetMapping("/inicio")
    public String inicio(HttpSession session) {

        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/auth/login";
        }

        return "inicio";
    }
}