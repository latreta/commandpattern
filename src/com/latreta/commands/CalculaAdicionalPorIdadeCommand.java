package com.latreta.commands;

import com.latreta.IPessoa;
import com.latreta.ISeguro;

public class CalculaAdicionalPorIdadeCommand implements Command{
    IPessoa pessoa;
    ISeguro seguro;
    double valorAdicional;

    public CalculaAdicionalPorIdadeCommand(IPessoa pessoa, ISeguro seguro){
        this.pessoa = pessoa;
        this.seguro = seguro;
        this.valorAdicional = 0.0;
    }

    @Override
    public void execute() {
        double multiplicador = pessoa.getIdade() <= 23 || pessoa.getIdade() >= 60 ? 1.5 : 1;
        valorAdicional = multiplicador * 50;
        System.out.println("Adicionando valor referente a idade do condutor, R$ " + valorAdicional);
        seguro.adicionarValor(valorAdicional);
    }

    @Override
    public void undo() {
        System.err.println("Removendo valor referente a idade do condutor, R$ " + valorAdicional);
        seguro.removerValor(valorAdicional);
    }
}
