package com.tecnologico.FruverLifes.Service;
import com.tecnologico.FruverLifes.controllers.RegistrodeUsuarioControllers;
import com.tecnologico.FruverLifes.model.Usuario;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class GestorUsuarioService {

    private static final String ARCHIVO_USUARIO = RutaService.RUTA_USUARIOS;

    public void primerUsuario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIO, true))) {
            // Solo escribir si el archivo está vacío
            File file = new File(ARCHIVO_USUARIO);
            if (file.length() == 0) {
                writer.write("Neidon|Gerente|Neidon123");
                writer.newLine();
                System.out.println("Usuario predeterminado creado.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear usuario predeterminado: " + e.getMessage());
        }
    }

    public void registrarUsuarios (Usuario usuario) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIO, true))) {
            writer.write(usuario.getUsuario() + "|" + usuario.getCargo() + "|" + usuario.getContrasenia());
            writer.newLine();
            System.out.println("Usuario registrado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
        }
    }
}

