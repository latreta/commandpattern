package com.latreta;

public class Carro implements ICarro{
    private String modelo;
    private String marca;
    private int anoDoCarro;
    private double valorDoCarro;

    public Carro(String modelo, String marca, int anoDoCarro, double valorDoCarro){
        this.modelo = modelo;
        this.marca = marca;
        this.anoDoCarro = anoDoCarro;
        this.valorDoCarro = valorDoCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAnoDoCarro(int anoDoCarro) {
        this.anoDoCarro = anoDoCarro;
    }

    public void setValorDoCarro(double valorDoCarro) {
        this.valorDoCarro = valorDoCarro;
    }

    @Override
    public double getValor() {
        return valorDoCarro;
    }

    @Override
    public int getAno() {
        return anoDoCarro;
    }
}
