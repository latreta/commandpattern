package com.latreta;

import com.latreta.commands.*;

public class Main {

    public static void main(String[] args) {
        ISeguro seguro = new Seguro();
        IPessoa pessoa = new Pessoa("Pessoa", 25, 3);
        ICarro carro = new Carro("KA", "Ford", 2008, 23000);

        // Usando um MacroCommand como Classe Invoker do evento
        CalculaSegurosCommand calculaSegurosCommand = new CalculaSegurosCommand();

        calculaSegurosCommand.adicionarCalculo(new CalculaValorBaseSeguroCommand(carro, seguro)); // Adiciona o valor base comum a todos seguros
        calculaSegurosCommand.adicionarCalculo(new CalculaAdicionalPorAnoDoCarroCommand(seguro, carro));
        calculaSegurosCommand.adicionarCalculo(new CalculaAdicionalPorIdadeCommand(pessoa, seguro));
        calculaSegurosCommand.adicionarCalculo(new CalculaDescontoPorTempoHabilitacaoCommand(pessoa, seguro));

        System.out.println(seguro);

        calculaSegurosCommand.execute();

        System.out.println(seguro);

        System.err.println("Desfazendo os cálculos");

        calculaSegurosCommand.undo();

        System.err.println(seguro);

    }
}
