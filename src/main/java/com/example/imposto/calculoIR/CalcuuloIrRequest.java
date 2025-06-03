package com.example.imposto.calculoIR;

public class CalcuuloIrRequest {
    private int ano;
    private double rendaAnual;
    private int dependentes;
    private double despesasInstrucao;
    private boolean simplificado;
    
    public CalcuuloIrRequest() {
    }

    public CalcuuloIrRequest(int ano, double rendaAnual, int dependentes, double despesasInstrucao,
            boolean simplificado) {
        this.ano = ano;
        this.rendaAnual = rendaAnual;
        this.dependentes = dependentes;
        this.despesasInstrucao = despesasInstrucao;
        this.simplificado = simplificado;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public double getDespesasInstrucao() {
        return despesasInstrucao;
    }

    public void setDespesasInstrucao(double despesasInstrucao) {
        this.despesasInstrucao = despesasInstrucao;
    }

    public boolean isSimplificado() {
        return simplificado;
    }

    public void setSimplificado(boolean simplificado) {
        this.simplificado = simplificado;
    }

    
}
