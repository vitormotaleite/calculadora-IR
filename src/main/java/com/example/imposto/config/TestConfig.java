package com.example.imposto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.imposto.entities.Pessoa;
import com.example.imposto.repository.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {
        Pessoa p1 = new Pessoa("joao amorim", "123-456-789-20", 60000);
        Pessoa p2 = new Pessoa("taison pereira", "987-765-432-56", 100000);

        pessoaRepository.saveAll(Arrays.asList(p1,p2));
    }
    
}
