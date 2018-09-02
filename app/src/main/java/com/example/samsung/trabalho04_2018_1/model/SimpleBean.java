package com.example.samsung.trabalho04_2018_1.model;


import java.io.Serializable;

public abstract class SimpleBean implements Serializable {

    protected String id;
    protected String nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
