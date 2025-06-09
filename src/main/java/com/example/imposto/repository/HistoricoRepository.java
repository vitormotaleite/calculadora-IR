package com.example.imposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imposto.calculoIR.HistoricoCalculo;

public interface HistoricoRepository extends JpaRepository<HistoricoCalculo,Long> {
    
}
