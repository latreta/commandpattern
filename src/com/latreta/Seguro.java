package com.latreta;

public class Seguro implements ISeguro{
    double valor;

    public Seguro(){
        this.valor = 0;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public void adicionarValor(double valor) {
        this.valor += valor;
    }

    @Override
    public void removerValor(double valor) {
        this.valor -= valor;
    }

    public String toString(){
        return "Valor total do seguro: " + valor;
    }
}
