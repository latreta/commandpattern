package com.latreta.commands;

import com.latreta.ICarro;
import com.latreta.ISeguro;

public class CalculaValorBaseSeguroCommand implements Command{
    ISeguro seguro;
    ICarro carro;
    double valorBase;

    public CalculaValorBaseSeguroCommand(ICarro carro, ISeguro seguro){
        this.seguro = seguro;
        this.carro = carro;
        this.valorBase = 0.0;
    }

    @Override
    public void execute() {
        valorBase = this.carro.getValor() * 0.0125; // 1,25% do Valor do carro.
        System.out.println("Adicionando um valor base de R$" + valorBase);
        seguro.adicionarValor(valorBase);
    }

    @Override
    public void undo() {
        System.err.println("Removendo o valor base de R$" + valorBase);
        seguro.removerValor(valorBase);
    }
}
