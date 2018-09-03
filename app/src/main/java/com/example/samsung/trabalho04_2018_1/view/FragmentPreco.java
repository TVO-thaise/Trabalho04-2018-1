package com.example.samsung.trabalho04_2018_1.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.samsung.trabalho04_2018_1.adapter.SimpleBeanRecyclerViewAdapter;
import com.example.samsung.trabalho04_2018_1.holder.PrecoViewHolder;
import com.example.samsung.trabalho04_2018_1.holder.SimpleBeanViewHolder;
import com.example.samsung.trabalho04_2018_1.model.Modelo;
import com.example.samsung.trabalho04_2018_1.model.Preco;
import com.example.samsung.trabalho04_2018_1.service.FipeService;
import com.example.samsung.trabalho04_2018_1.service.ServiceCallback;

import java.util.ArrayList;

public class FragmentPreco extends AbstractFragment<Preco, Modelo>{

    public static FragmentPreco getInstance(Modelo modelo){
        FragmentPreco fragment = new FragmentPreco();
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
    public void createData(final SimpleBeanRecyclerViewAdapter<Preco> adapter) {
        new FipeService((MainActivity)getActivity()).getPreco(parameter, new ServiceCallback<ArrayList<Preco>>() {
            @Override
            public void onSuccess(ArrayList<Preco> data) {
                adapter.setData(data);
            }
        });
    }

    @Override
    protected SimpleBeanViewHolder createHolder(LayoutInflater inflater, ViewGroup parent) {
        return new PrecoViewHolder(inflater, parent);
    }

    @Override
    protected boolean enableSearch() {
        return false;
    }

    @Override
    public void onClick(Preco obj) {
        //TODO
        ((MainActivity)getActivity()).closeSearch();
    }
}