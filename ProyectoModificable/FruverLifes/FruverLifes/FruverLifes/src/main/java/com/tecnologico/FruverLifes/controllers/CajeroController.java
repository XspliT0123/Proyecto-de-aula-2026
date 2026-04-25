package com.tecnologico.FruverLifes.controllers;

import com.tecnologico.FruverLifes.Service.CajeroService;
import com.tecnologico.FruverLifes.model.Cajero;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class CajeroController {

    private final CajeroService service;
    public CajeroController(CajeroService service) {

        this.service = service;
    }
    @PostMapping
    public String vender(@RequestBody Cajero request) {
        return service.procesarVenta(request);
    }
}