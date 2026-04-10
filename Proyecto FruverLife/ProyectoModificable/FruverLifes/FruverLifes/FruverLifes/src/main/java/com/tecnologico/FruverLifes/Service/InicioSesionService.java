package com.tecnologico.FruverLifes.Service;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class InicioSesionService {

    private static final String RUTA_USUARIOS = RutaService.RUTA_USUARIOS;

    public static String obtenerCargo(String usuarioBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                // Formato esperado: usuario|cargo|contrasena
                if (datos.length >= 3) {
                    String usuario = datos[0].trim();
                    String cargo   = datos[1].trim();

                    if (usuario.equals(usuarioBuscado)) {
                        return cargo;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return null;
    }

    public static boolean verificarUsuario(String usuarioIngresado, String contrasenaIngresada) {
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_USUARIOS))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split("\\|");

                if (datos.length >= 3) {
                    String usuario    = datos[0].trim();
                    String cargo      = datos[1].trim();
                    String contrasena = datos[2].trim();
                    if (usuario.equals(usuarioIngresado) && contrasena.equals(contrasenaIngresada)) {
                        return true;
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios.");
        }
        return false;
    }

}
