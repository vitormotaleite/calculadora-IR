package com.example.imposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imposto.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    
}
