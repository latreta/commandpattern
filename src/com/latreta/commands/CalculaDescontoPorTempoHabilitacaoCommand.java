package com.latreta.commands;

import com.latreta.IPessoa;
import com.latreta.ISeguro;

public class CalculaDescontoPorTempoHabilitacaoCommand implements Command{
    IPessoa pessoa;
    ISeguro seguro;
    double valorAdicional;

    public CalculaDescontoPorTempoHabilitacaoCommand(IPessoa pessoa, ISeguro seguro){
        this.pessoa = pessoa;
        this.seguro = seguro;
        this.valorAdicional = 0.0;
    }

    @Override
    public void execute() {
        // 50 reais de desconto por anos de habilitações
        this.valorAdicional = 50 * pessoa.getTempoDeHabilitacao();
        System.out.println("Desconto oferecido de R$ " + this.valorAdicional);
        seguro.removerValor(valorAdicional);
    }

    @Override
    public void undo() {
        // Retira o desconto
        System.err.println("Removendo desconto oferecido de R$ " + this.valorAdicional);
        seguro.adicionarValor(valorAdicional);
    }
}
