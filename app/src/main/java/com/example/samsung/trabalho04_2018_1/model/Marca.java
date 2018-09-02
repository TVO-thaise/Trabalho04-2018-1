package com.example.samsung.trabalho04_2018_1.model;

public class Marca extends MainActivity{

    private Tipo tipo;

    public Marca() {}

    public Marca(String id, String nome, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
