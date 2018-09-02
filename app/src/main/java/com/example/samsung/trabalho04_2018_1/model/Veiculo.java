package com.example.samsung.trabalho04_2018_1.model;

public class Veiculo extends SimpleBean {

    private Marca marca;

    public Veiculo() {}

    public Veiculo(String id, String nome, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
