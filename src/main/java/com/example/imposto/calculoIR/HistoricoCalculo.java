package com.example.imposto.calculoIR;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_historico_calculo")
public class HistoricoCalculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ano;
    private Double rendaAnual;
    private Integer dependentes;
    private Double despesasInstrucao;
    private Boolean simplificado;

    private Double baseCalculo;
    private Double imposto;
    private String modelo;

    @CreationTimestamp
    private LocalDateTime dataHora;

    public HistoricoCalculo() {
    }

    public HistoricoCalculo(Long id, Integer ano, Double rendaAnual, Integer dependentes, Double despesasInstrucao,
            Boolean simplificado, Double baseCalculo, Double imposto, String modelo, LocalDateTime dataHora) {
        this.id = id;
        this.ano = ano;
        this.rendaAnual = rendaAnual;
        this.dependentes = dependentes;
        this.despesasInstrucao = despesasInstrucao;
        this.simplificado = simplificado;
        this.baseCalculo = baseCalculo;
        this.imposto = imposto;
        this.modelo = modelo;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public Double getDespesasInstrucao() {
        return despesasInstrucao;
    }

    public void setDespesasInstrucao(Double despesasInstrucao) {
        this.despesasInstrucao = despesasInstrucao;
    }

    public Boolean getSimplificado() {
        return simplificado;
    }

    public void setSimplificado(Boolean simplificado) {
        this.simplificado = simplificado;
    }

    public Double getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(Double baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @PrePersist
    public void PrePersist() {
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HistoricoCalculo other = (HistoricoCalculo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
