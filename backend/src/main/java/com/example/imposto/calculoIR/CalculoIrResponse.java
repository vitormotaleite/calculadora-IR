package com.example.imposto.calculoIR;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoIrResponse {
    private double baseCalculo;
    private double imposto;
    private String modelo;
    
    public CalculoIrResponse() {
    }

    public CalculoIrResponse(double baseCalculo, double imposto, String modelo) {
        this.baseCalculo = baseCalculo;
        this.imposto = imposto;
        this.modelo = modelo;
    }

    public double getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(double baseCalculo) {
        this.baseCalculo = arredondar(baseCalculo);
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = arredondar(imposto);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    private double arredondar(double valor) {
        return new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
