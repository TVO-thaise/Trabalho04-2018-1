package com.example.samsung.trabalho04_2018_1.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.samsung.trabalho04_2018_1.adapter.SimpleBeanRecyclerViewAdapter;
import com.example.samsung.trabalho04_2018_1.holder.SimpleBeanViewHolder;
import com.example.samsung.trabalho04_2018_1.holder.ValorViewHolder;
import com.example.samsung.trabalho04_2018_1.model.Modelo;
import com.example.samsung.trabalho04_2018_1.model.Valor;

import java.util.ArrayList;

public class FragmentValor extends AbstractFragment<Valor, Modelo>{

    public static FragmentValor getInstance(Modelo modelo){
        FragmentValor fragment = new FragmentValor();
        Bundle args = new Bundle();
        args.putSerializable(PARAMETER, modelo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String createTitle() {
        return "Consulta FIPE";
    }

    @Override
    public String createSubTitle() {
        return null;
    }

    @Override
    public void createData(final SimpleBeanRecyclerViewAdapter<Valor> adapter) {
        new FipeService((MainActivity)getActivity()).getPreco(parameter, new ServiceCallback<ArrayList<Valor>>() {
            @Override
            public void onSuccess(ArrayList<Valor> data) {
                adapter.setData(data);
            }
        });
    }

    @Override
    protected SimpleBeanViewHolder createHolder(LayoutInflater inflater, ViewGroup parent) {
        return new ValorViewHolder(inflater, parent);
    }

    @Override
    protected boolean enableSearch() {
        return false;
    }

    @Override
    public void onClick(Valor obj) {
        //TODO
        ((MainActivity)getActivity()).closeSearch();
    }
}
