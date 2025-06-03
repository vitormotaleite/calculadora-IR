package com.example.imposto.service;

import org.springframework.stereotype.Service;

import com.example.imposto.calculoIR.CalculoIrResponse;
import com.example.imposto.calculoIR.CalcuuloIrRequest;
import com.example.imposto.faixa.FaixaIR;
import com.example.imposto.tabelas.TabelaIR;
import com.example.imposto.tabelas.TabelaPorAno;

@Service
public class CalculadoraService {
    
    public CalculoIrResponse calcularImposto(CalcuuloIrRequest req) {
        TabelaIR tabela = TabelaPorAno.pegarTabela(req.getAno());

        double base;

        if(req.isSimplificado()) {
            base = Math.max(0, req.getRendaAnual() - tabela.getDescontoSimplificado());
        }
        else {
            double deducaoDep = req.getDependentes() * tabela.getDeducaoDependente();
            double deducaoInstr = Math.min(req.getDespesasInstrucao(), tabela.getLimiteInstrucao());
            base = Math.max(0, req.getRendaAnual() - deducaoDep - deducaoInstr);
        }

        FaixaIR faixa = tabela.getFaixas().stream().filter(f -> f.getLimiteSuperior() == null ||  base <= f.getLimiteSuperior()).findFirst().orElse(null);
        double imposto = 0.0;

        if(faixa != null && faixa.getAliquota() > 0) {
            imposto = base * faixa.getAliquota() - faixa.getDeducao();
        }

        CalculoIrResponse resp = new CalculoIrResponse();
        resp.setBaseCalculo(base);
        resp.setImposto(Math.max(0, imposto));
        resp.setModelo(req.isSimplificado() ? "Simplificado" : "Completo");
        return resp;
    }
}
