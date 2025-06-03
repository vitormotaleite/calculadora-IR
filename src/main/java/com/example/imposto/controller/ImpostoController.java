package com.example.imposto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.imposto.calculoIR.CalculoIrResponse;
import com.example.imposto.calculoIR.CalcuuloIrRequest;
import com.example.imposto.service.CalculadoraService;

@RestController
@RequestMapping("/api/imposto")
public class ImpostoController {

    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping
    public CalculoIrResponse calcular(@RequestBody CalcuuloIrRequest req) {
        return calculadoraService.calcularImposto(req);
    }
    
}
