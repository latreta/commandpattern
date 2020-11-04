package com.latreta;

public class Pessoa implements IPessoa{
    private String nome;
    private int idade;
    private int tempoHabilitacao;

    public Pessoa(String nome, int idade, int tempoHabilitacao){
        this.nome = nome;
        this.idade = idade;
        this.tempoHabilitacao = tempoHabilitacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTempoHabilitacao(int tempoHabilitacao){
        this.tempoHabilitacao = tempoHabilitacao;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getIdade() {
        return idade;
    }

    @Override
    public int getTempoDeHabilitacao() {
        return tempoHabilitacao;
    }
}
