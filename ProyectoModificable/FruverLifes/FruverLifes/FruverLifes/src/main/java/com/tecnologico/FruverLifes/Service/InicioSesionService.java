package com.tecnologico.FruverLifes.Service;

import com.tecnologico.FruverLifes.model.Usuario;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class InicioSesionService {

    private static final String RUTA_USUARIOS = RutaService.RUTA_USUARIOS;
    public Usuario obtenerUsuario(String usuarioBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_USUARIOS))) {

            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 3) {
                    String usuario    = datos[0].trim();
                    String cargo      = datos[1].trim();
                    String contrasena = datos[2].trim();

                    if (usuario.equals(usuarioBuscado)) {
                        return new Usuario(usuario, contrasena, cargo);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer usuarios: " + e.getMessage());
        }
        return null;
    }

    public boolean verificarUsuario(String usuarioIngresado, String contrasenaIngresada) {
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_USUARIOS))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 3) {
                    String usuario    = datos[0].trim();
                    String contrasena = datos[2].trim();
                    if (usuario.equals(usuarioIngresado) &&
                            contrasena.equals(contrasenaIngresada)) {
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios.");
        }
        return false;
    }

    public String obtenerCargo(String usuarioBuscado) {
        Usuario usuario = obtenerUsuario(usuarioBuscado);
        if (usuario != null) {
            return usuario.getCargo();
        }
        return null;
    }
}