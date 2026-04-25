package com.tecnologico.FruverLifes.Service;


import com.tecnologico.FruverLifes.model.Cajero;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.*;

@Service
public class CajeroService {

    private final String RUTA_PRODUCTOS =
            System.getProperty("user.dir") + File.separator + "productos.txt";

    private final String RUTA_VENTAS =
            System.getProperty("user.dir") + File.separator + "ventas.txt";

    public String procesarVenta(@NonNull Cajero request) {

        Map<String, Double> productosAVender = request.getProductos();

        if (productosAVender.isEmpty()) {
            return "No hay productos para vender";
        }

        List<String> lineasProductos;
        try {
            lineasProductos = Files.readAllLines(new File(RUTA_PRODUCTOS).toPath());
        } catch (IOException e) {
            return "Error leyendo productos";
        }

        String fechaVenta = LocalDate.now().toString();
        String vendedorCampo = request.getUsuario() + " (" + request.getCargo() + ")";

        double totalVenta = 0;
        List<String> nuevasLineasStock = new ArrayList<>();
        List<String> lineasVenta = new ArrayList<>();

        for (String linea : lineasProductos) {

            if (linea.trim().isEmpty()) continue;

            String[] datos = linea.split("\\|");

            if (datos.length != 4) {
                nuevasLineasStock.add(linea);
                continue;
            }

            String codigo = datos[0].trim();
            String nombre = datos[1].trim();

            double cantidadActual = Double.parseDouble(datos[2].trim());
            double valorUnitario = Double.parseDouble(datos[3].trim());

            double cantidadVendida = productosAVender.getOrDefault(codigo, 0.0);

            if (cantidadVendida > 0) {

                if (cantidadVendida > cantidadActual) {
                    return "Stock insuficiente para: " + nombre;
                }

                cantidadActual -= cantidadVendida;

                double totalProducto = cantidadVendida * valorUnitario;
                totalVenta += totalProducto;

                String lineaVenta = fechaVenta + "|" + vendedorCampo + "|" +
                        codigo + "|" + nombre + "|" + cantidadVendida + "|" + totalProducto;

                lineasVenta.add(lineaVenta);
            }

            nuevasLineasStock.add(
                    codigo + "|" + nombre + "|" + cantidadActual + "|" + valorUnitario
            );
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_PRODUCTOS))) {
            for (String l : nuevasLineasStock) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            return "Error guardando stock";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_VENTAS, true))) {
            for (String l : lineasVenta) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            return "Error guardando venta";
        }

        return "Venta realizada. Total: " + totalVenta;
    }
}