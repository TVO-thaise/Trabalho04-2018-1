package com.example.samsung.trabalho04_2018_1.model;

import com.example.samsung.trabalho04_2018_1.R;

public class Tipo extends SimpleBean{

    public static final Tipo[] TIPOS = {
            new Tipo("Carros", "carros", R.drawable.ic_carros),
            new Tipo("Motos", "motos", R.drawable.ic_motos),
            new Tipo("Caminhões", "caminhoes", R.drawable.ic_caminhoes)
    };

    private String tipo;
    private int icon;

    private Tipo(String name, String tipo, int icon) {
        this.nome = nome;
        this.tipo = tipo;
        this.icon = icon;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIcon() {
        return icon;
    }
}
