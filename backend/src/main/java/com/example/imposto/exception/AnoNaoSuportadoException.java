package com.example.imposto.exception;

public class AnoNaoSuportadoException extends RuntimeException {

    public AnoNaoSuportadoException(int ano) {
        super("Ano não suportado: " + ano);
    }
    
}
