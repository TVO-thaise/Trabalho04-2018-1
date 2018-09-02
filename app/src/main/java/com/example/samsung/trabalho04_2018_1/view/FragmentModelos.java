package com.example.samsung.trabalho04_2018_1.view;

import android.os.Bundle;

import com.example.samsung.trabalho04_2018_1.adapter.SimpleBeanRecyclerViewAdapter;
import com.example.samsung.trabalho04_2018_1.model.Modelo;
import com.example.samsung.trabalho04_2018_1.model.Veiculo;

import java.util.ArrayList;
import java.util.Collections;

public class FragmentModelos extends AbstractFragment<Modelo,Veiculo>{

    public static FragmentModelos getInstance(Veiculo veiculo){
        FragmentModelos fragment = new FragmentModelos();
        Bundle args = new Bundle();
        args.putSerializable(PARAMETER, veiculo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String createTitle() {
        return "Modelos";
    }

    @Override
    public String createSubTitle() {
        return parameter.getNome();
    }

    @Override
    public void createData(final SimpleBeanRecyclerViewAdapter<Modelo> adapter) {
        new FipeService((MainActivity)getActivity()).getModelos(parameter, new ServiceCallback<ArrayList<Modelo>>() {
            @Override
            public void onSuccess(ArrayList<Modelo> data) {
                Collections.reverse(data);
                adapter.setData(data);
            }
        });
    }

    @Override
    public void onClick(Modelo obj) {
        ((MainActivity)getActivity()).showFragment(FragmentValor.getInstance(obj));
    }
}
