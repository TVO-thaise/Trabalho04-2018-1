package com.example.samsung.trabalho04_2018_1.model;

public class Tipo {

    public static final Tipo[] TIPOS = {
            new Tipo("Carros", "carros", R.drawable.ic_carros),
            new Tipo("Motos", "motos", R.drawable.ic_motos),
            new Tipo("Caminhões", "caminhoes", R.drawable.ic_caminhoes)
    };

    private String tipo;
    private String nome;


    private Tipo(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }

}
