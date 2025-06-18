package com.example.imposto.calculoIR;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CalcuuloIrRequest {
    
    @NotNull(message = "o ano é obrigatório")
    private int ano;
    @NotNull(message =  "a renda anual é obrigatória")
    @Positive(message = "a renda anual deve ser maior que zero")
    private double rendaAnual;
    @NotNull(message =  "o número de dependentes é obrigatório")
    @Min(value = 0, message = "número de dependentes não pode ser negativo")
    private int dependentes;
    @NotNull(message =  "as despesas de instrução são obrigatórias")
    @Min(value = 0, message = "despesas de instrução não podem ser negativas")
    private double despesasInstrucao;
    @NotNull(message =  "é necessário informar se deseja ser simplificado")
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
