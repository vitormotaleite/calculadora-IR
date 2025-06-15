package com.example.imposto.tabelas;

import java.util.Map;

import com.example.imposto.exception.AnoNaoSuportadoException;

public class TabelaPorAno {

    public static TabelaIR pegarTabela(int ano) {
        if(!tabelas.containsKey(ano)) {
            throw new AnoNaoSuportadoException(ano);
        }
        return tabelas.get(ano);
    }

    private static final Map<Integer,TabelaIR> tabelas = Map.of(
        2024, TabelaIR.de2024(),
        2025, TabelaIR.de2025(),
        2026, TabelaIR.de2026()
    );
    
}
