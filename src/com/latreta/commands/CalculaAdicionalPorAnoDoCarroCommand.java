package com.latreta.commands;

import com.latreta.ICarro;
import com.latreta.ISeguro;

public class CalculaAdicionalPorAnoDoCarroCommand implements Command{
    ISeguro seguro;
    ICarro carro;
    double valorAdicional;

    public CalculaAdicionalPorAnoDoCarroCommand(ISeguro seguro, ICarro carro){
        this.seguro = seguro;
        this.carro = carro;
        valorAdicional = 0.0;
    }

    @Override
    public void execute() {
        valorAdicional = 50 * (getAnoAtual() - carro.getAno());
        System.out.println("Adicionando valor referente ao ano do modelo, R$ " + valorAdicional);
        seguro.adicionarValor(valorAdicional);
    }

    private int getAnoAtual(){
        return 2020;
    }

    @Override
    public void undo() {
        System.err.println("Removendo valor referente ao ano do modelo, R$ " + valorAdicional);
        seguro.removerValor(valorAdicional);
    }
}
