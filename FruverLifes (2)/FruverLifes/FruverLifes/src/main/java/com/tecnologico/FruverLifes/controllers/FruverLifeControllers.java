package com.tecnologico.FruverLifes.controllers;


import com.tecnologico.FruverLifes.model.FruverLifemodel;
import com.tecnologico.FruverLifes.services.FruverLifeimplet;
import com.tecnologico.FruverLifes.services.FruverLifeservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FruverLifeControllers {

    private final FruverLifeservices fruverLifeservices;

    public FruverLifeControllers( FruverLifeservices fruverLifeservices) {
        this.fruverLifeservices = fruverLifeservices;
    }
        @GetMapping("Inventario")
        public List<FruverLifemodel> Lista () {
            return fruverLifeservices.listar();
        }

}
