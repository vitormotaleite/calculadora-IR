package com.example.imposto.tabelas;

import java.util.ArrayList;
import java.util.List;

import com.example.imposto.faixa.FaixaIR;

public class TabelaIR {
    
    private List<FaixaIR> faixas = new ArrayList<>();
    private double deducaoDependente;
    private double limiteInstrucao;
    private double descontoSimplificado;
    
    public TabelaIR() {
    }

    public TabelaIR(double deducaoDependente, double limiteInstrucao, double descontoSimplificado) {
        this.deducaoDependente = deducaoDependente;
        this.limiteInstrucao = limiteInstrucao;
        this.descontoSimplificado = descontoSimplificado;
    }

    public List<FaixaIR> getFaixas() {
        return faixas;
    }

    public double getDeducaoDependente() {
        return deducaoDependente;
    }

    public void setDeducaoDependente(double deducaoDependente) {
        this.deducaoDependente = deducaoDependente;
    }

    public double getLimiteInstrucao() {
        return limiteInstrucao;
    }

    public void setLimiteInstrucao(double limiteInstrucao) {
        this.limiteInstrucao = limiteInstrucao;
    }

    public double getDescontoSimplificado() {
        return descontoSimplificado;
    }

    public void setDescontoSimplificado(double descontoSimplificado) {
        this.descontoSimplificado = descontoSimplificado;
    }

    public static TabelaIR de2026() {
        TabelaIR tab = new TabelaIR();
        tab.faixas = List.of(
            new FaixaIR(27110.40, 0, 0),
            new FaixaIR(33919.80, 0.075, 2033.28),
            new FaixaIR(45012.60, 0.15, 4577.27),
            new FaixaIR(55976.16, 0.225, 7953.21),
            new FaixaIR(null, 0.275, 10752.02)
        );
        tab.setDeducaoDependente(2275.08);
        tab.setLimiteInstrucao(3561.50);
        tab.setDescontoSimplificado(16754.34);
        return tab;
    }
    
    public static TabelaIR de2025() {
        TabelaIR tab = new TabelaIR();
        tab.faixas = List.of(
            new FaixaIR(26963.20, 0, 0),
            new FaixaIR(33919.80, 0.075, 2022.24),
            new FaixaIR(45012.60, 0.15, 4566.23),
            new FaixaIR(55976.16, 0.225, 7942.17),
            new FaixaIR(null, 0.275, 10740.98)
        );
        tab.setDeducaoDependente(2275.08);
        tab.setLimiteInstrucao(3561.50);
        tab.setDescontoSimplificado(16754.34);
        return tab;
    }

    public static TabelaIR de2024() {
        TabelaIR tab = new TabelaIR();
        tab.faixas = List.of(
           new FaixaIR(24511.92, 0, 0),
            new FaixaIR(33919.80, 0.075, 1838.39),
            new FaixaIR(45012.60, 0.15, 4382.38),
            new FaixaIR(55976.16, 0.225, 7758.32),
            new FaixaIR(null, 0.275, 10557.13)
        );
        tab.setDeducaoDependente(2275.08);
        tab.setLimiteInstrucao(3561.50);
        tab.setDescontoSimplificado(16754.34);
        return tab;
    }

    public double calcularImposto(double base) {
        double imposto = 0.0;
        double baseRestante = base;
        double limiteInferior = 0.0;

        for(FaixaIR faixa: faixas) {
            Double limiteSuperior = faixa.getLimiteSuperior();
            double aliquota = faixa.getAliquota();

            if(limiteSuperior == null) {
                imposto += (baseRestante - limiteInferior) * aliquota;
                break;
            }

            if(base > limiteSuperior) {
                imposto += (limiteSuperior - limiteInferior) * aliquota;
            }
            else {
                imposto += (base - limiteInferior) * aliquota;
                break;
            }

            limiteInferior = limiteSuperior;
        }

        for(int i = faixas.size() - 1; i >= 0; i--) {
            Double limite = faixas.get(i).getLimiteSuperior();
            if(limite == null || base <= limite) {
                imposto -= faixas.get(i).getDeducao();
                break;
            }
        }

        return Math.max(0, imposto);

    }
    
}
