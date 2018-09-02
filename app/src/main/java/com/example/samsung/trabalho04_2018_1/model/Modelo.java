package com.example.samsung.trabalho04_2018_1.model;

public class Modelo extends MainActivity {

    private Veiculo veiculo;

    public Modelo() {}

    public Modelo(String id, String name, Veiculo veiculo) {
        this.id = id;
        this.name = name;
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
