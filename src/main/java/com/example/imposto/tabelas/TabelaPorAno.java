package com.example.imposto.tabelas;

public class TabelaPorAno {

    public static TabelaIR pegarTabela(int ano) {
        switch (ano) {
            case 2026:
                return TabelaIR.de2026();
            case 2025:
                return TabelaIR.de2025();
            case 2024:
                return TabelaIR.de2024();
            default:
                throw new RuntimeException("Ano não suportado: " + ano);
        }
    }
    
}
