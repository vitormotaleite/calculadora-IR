package com.example.imposto.model;

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
        this.baseCalculo = baseCalculo;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
}
