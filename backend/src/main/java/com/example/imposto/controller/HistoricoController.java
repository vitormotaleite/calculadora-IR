package com.example.imposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imposto.calculoIR.HistoricoCalculo;
import com.example.imposto.repository.HistoricoRepository;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private HistoricoRepository historicoRepository;

    @GetMapping
    public List<HistoricoCalculo> buscarHistorico(@RequestParam(required = false) Integer ano, @RequestParam(required = false) String modelo) {
        if(ano != null && modelo != null) {
            return historicoRepository.findByAnoAndModeloOrderByIdDesc(ano, modelo);
        }
        else if(ano != null) {
            return historicoRepository.findByAnoOrderByIdDesc(ano);
        }
        else if(modelo != null) {
            return historicoRepository.findByModeloOrderByIdDesc(modelo);
        }
        else {
            return historicoRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"))).getContent();
        }
    }
    
}
