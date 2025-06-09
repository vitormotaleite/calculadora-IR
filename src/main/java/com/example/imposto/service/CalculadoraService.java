package com.example.imposto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imposto.calculoIR.CalculoIrResponse;
import com.example.imposto.calculoIR.CalcuuloIrRequest;
import com.example.imposto.calculoIR.HistoricoCalculo;
import com.example.imposto.repository.HistoricoRepository;
import com.example.imposto.tabelas.TabelaPorAno;

import lombok.var;

@Service
public class CalculadoraService {

    @Autowired
    HistoricoRepository historicoRepository;

    public CalculoIrResponse calcularImposto(CalcuuloIrRequest request) {

        var dadosAno = TabelaPorAno.pegarTabela(request.getAno());

        double renda = request.getRendaAnual();
        double deducaodependentes = request.getDependentes() * dadosAno.getDeducaoDependente();
        double deducaoInstrucao = Math.min(request.getDespesasInstrucao(), dadosAno.getLimiteInstrucao());

        double baseCompleta = renda - deducaodependentes -deducaoInstrucao;
        double impostoCompleto = dadosAno.calcularImposto(baseCompleta);

        double descontoSimplificado = Math.min(dadosAno.getDescontoSimplificado(), renda * 0.2);
        double baseSimplificada = renda - descontoSimplificado;
        double impostoSimplificado = dadosAno.calcularImposto(baseSimplificada);

        boolean usarSimplificado = request.isSimplificado() && impostoSimplificado < impostoCompleto;

        double impostoFinal = usarSimplificado ? impostoSimplificado: impostoCompleto;
        double baseFinal = usarSimplificado ? baseSimplificada: baseCompleta;

        CalculoIrResponse response = new CalculoIrResponse();
        response.setImposto(arredondar(impostoFinal));
        response.setBaseCalculo(arredondar(baseFinal));
        response.setModelo(usarSimplificado ? "Simplificado" : "Completo");

        HistoricoCalculo historico = new HistoricoCalculo();
        historico.setAno(request.getAno());
        historico.setRendaAnual(request.getRendaAnual());
        historico.setDependentes(request.getDependentes());
        historico.setDespesasInstrucao(request.getDespesasInstrucao());
        historico.setSimplificado(request.isSimplificado());
        historico.setBaseCalculo(response.getBaseCalculo());
        historico.setImposto(response.getImposto());
        historico.setModelo(response.getModelo());

        historicoRepository.save(historico);
        return response;
    }

    private double arredondar(double valor) {
        return new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    
    
}
