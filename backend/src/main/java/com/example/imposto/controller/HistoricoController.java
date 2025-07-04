package com.example.imposto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imposto.calculoIR.HistoricoCalculo;
import com.example.imposto.service.CalculadoraService;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping
    public Page<HistoricoCalculo> listarComPaginacao(
            @RequestParam(required = false) Integer ano,
            @RequestParam(required = false) String modelo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
                Pageable pageable = PageRequest.of(page, size);
                return calculadoraService.listarComFiltros(ano,modelo,pageable);

    }

}
