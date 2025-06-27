package com.example.imposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imposto.calculoIR.HistoricoCalculo;

public interface HistoricoRepository extends JpaRepository<HistoricoCalculo,Long> {

    List<HistoricoCalculo> findByAnoOrderByIdDesc(int ano);
    List<HistoricoCalculo> findByModeloOrderByIdDesc(String modelo);
    List<HistoricoCalculo> findByAnoAndModeloOrderByIdDesc(int ano, String modelo);
    
}
