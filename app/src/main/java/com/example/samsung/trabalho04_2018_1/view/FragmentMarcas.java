package com.example.samsung.trabalho04_2018_1.view;

import android.os.Bundle;

import com.example.samsung.trabalho04_2018_1.adapter.SimpleBeanRecyclerViewAdapter;
import com.example.samsung.trabalho04_2018_1.model.Marca;
import com.example.samsung.trabalho04_2018_1.model.Tipo;

import java.util.ArrayList;

public class FragmentMarcas extends AbstractFragment<Marca,Tipo> {

    public static FragmentMarcas getInstance(Tipo tipo){
        FragmentMarcas fragment = new FragmentMarcas();
        Bundle args = new Bundle();
        args.putSerializable(PARAMETER, tipo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String createTitle() {
        return "Marcas";
    }

    @Override
    public String createSubTitle() {
        return parameter.getNome();
    }

    @Override
    public void createData(final SimpleBeanRecyclerViewAdapter<Marca> adapter) {
        new FipeService((MainActivity)getActivity()).getMarcas(parameter, new ServiceCallback<ArrayList<Marca>>() {
            @Override
            public void onSuccess(ArrayList<Marca> data) {
                adapter.setData(data);
            }
        });
    }

    @Override
    public void onClick(Marca obj) {
        ((MainActivity)getActivity()).showFragment(FragmentVeiculos.getInstance(obj));
    }

}
