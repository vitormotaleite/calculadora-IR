package com.example.imposto.faixa;

public class FaixaIR {

    private Double limiteSuperior;
    private double aliquota;
    private double deducao;
    
    public FaixaIR() {
    }

    public FaixaIR(Double limiteSuperior, double aliquota, double deducao) {
        this.limiteSuperior = limiteSuperior;
        this.aliquota = aliquota;
        this.deducao = deducao;
    }

    public Double getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getDeducao() {
        return deducao;
    }

    public void setDeducao(double deducao) {
        this.deducao = deducao;
    }
}
