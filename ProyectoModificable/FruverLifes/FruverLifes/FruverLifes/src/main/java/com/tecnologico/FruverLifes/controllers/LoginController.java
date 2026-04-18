package com.tecnologico.FruverLifes.controllers;
import com.tecnologico.FruverLifes.Service.CargoService;
import com.tecnologico.FruverLifes.Service.InicioSesionService;
import com.tecnologico.FruverLifes.model.Usuario;
import jakarta.servlet.http.HttpSession;
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
    public String login(@ModelAttribute Usuario request, HttpSession session) {

        boolean valido = inicioSesionService.verificarUsuario(
                request.getUsuario(),
                request.getContrasenia()
        );

        if (valido) {
            Usuario usuario = inicioSesionService.obtenerUsuario(request.getUsuario());
            session.setAttribute("usuarioLogueado", usuario);
            String cargo = cargoService.obtenerCargo(request.getUsuario());
            if (cargo != null && cargo.equalsIgnoreCase("Gerente")) {
                return "redirect:/menu/gerente";
            } else if (cargo != null && cargo.equalsIgnoreCase("Administrador")) {
                return "redirect:/menu/Administrador";
            } else {
                return "redirect:/menu/Cajero";
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