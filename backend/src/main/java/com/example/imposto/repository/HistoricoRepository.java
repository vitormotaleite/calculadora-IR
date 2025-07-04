package com.example.imposto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imposto.calculoIR.HistoricoCalculo;

public interface HistoricoRepository extends JpaRepository<HistoricoCalculo,Long> {

    Page<HistoricoCalculo> findByAnoOrderByIdDesc(int ano, Pageable pageable);
    Page<HistoricoCalculo> findByModeloOrderByIdDesc(String modelo, Pageable pageable);
    Page<HistoricoCalculo> findByAnoAndModeloOrderByIdDesc(int ano, String modelo, Pageable pageable);
    
}
