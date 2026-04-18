package com.tecnologico.FruverLifes.Service;

import com.tecnologico.FruverLifes.model.Clientes;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class GestorClientesService {

    private static final String ARCHIVO_USUARIO = RutaService.RUTA_CLIENTES;

    public void registrarclientess(Clientes cliente) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RutaService.RUTA_CLIENTES, true))) {
            writer.write(cliente.getId() + "|" + cliente.getNombre() + "|" + cliente.getNumeroCe() + "|" + cliente.getCorreo());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Clientes> listars() {
        List<Clientes> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RutaService.RUTA_CLIENTES))) {
            String linea;
            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split("\\|");

                Clientes cliente = new Clientes(
                        Long.parseLong(datos[0]),
                        datos[1],
                        datos[2],
                        datos[3]
                );
                lista.add(cliente);
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return lista;
    }

    public void eliminar(long id) {
        List<Clientes> lista = listars();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RutaService.RUTA_CLIENTES))) {

            for (Clientes c : lista) {
                if (c.getId() != id) {
                    writer.write(c.getId() + "|" + c.getNombre() + "|" + c.getNumeroCe() + "|" + c.getCorreo());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}

