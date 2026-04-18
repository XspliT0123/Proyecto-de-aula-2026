package com.tecnologico.FruverLifes.Service;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class CargoService {

    public String obtenerCargo(String usuario) {

        String rutaArchivo = RutaService.RUTA_USUARIOS;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] partes = linea.split("\\|");

                if (partes.length >= 3) {

                    String usuarioArchivo = partes[0].trim();
                    String cargo = partes[1].trim();

                    if (usuarioArchivo.equalsIgnoreCase(usuario.trim())) {
                        return cargo;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return "Desconocido";
    }
}