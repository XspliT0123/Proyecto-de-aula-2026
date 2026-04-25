package com.tecnologico.FruverLifes.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/gerente")
    public String menuG(HttpSession session) {

        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/auth/login";
        }

        return "MenuGerente";
    }
    @GetMapping("/Administrador")
    public String menuA(HttpSession session) {

        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/auth/login";
        }
        return "MenuAdmi";
    }

    @GetMapping("/Cajero")
    public String menuC(HttpSession session) {

        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/auth/login";
        }

        return "MenuCajero";
    }
}