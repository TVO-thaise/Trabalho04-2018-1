package com.example.samsung.trabalho04_2018_1.view;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samsung.trabalho04_2018_1.R;
import com.example.samsung.trabalho04_2018_1.adapter.SimpleBeanRecyclerViewAdapter;
import com.example.samsung.trabalho04_2018_1.holder.SimpleBeanViewHolder;
import com.example.samsung.trabalho04_2018_1.model.SimpleBean;

import java.io.Serializable;
import java.util.ArrayList;

public class AbstractFragment <T extends SimpleBean, P extends Serializable> extends Fragment implements SimpleBeanViewHolder.HolderClickListener<T>{

    public static final String PARAMETER = "parameter";
    public static final String DATA = "data";

    private RecyclerView recyclerView;
    private SimpleBeanRecyclerViewAdapter<T> adapter;

    protected P parameter;
    private ArrayList<T> data;

    public abstract String createTitle();
    public abstract String createSubTitle();
    public abstract void createData(SimpleBeanRecyclerViewAdapter<T> adapter);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState!=null){
            parameter = (P)savedInstanceState.getSerializable(PARAMETER);
            data = (ArrayList<T>) savedInstanceState.getSerializable(DATA);

            Log.d(getClass().getSimpleName()," RESTORED SAVED INSTANCE - Parameter: "+parameter+" | DATA: "+(data==null?"NULL":data.size()));
        }else if (getArguments() != null) {
            parameter = (P)getArguments().getSerializable(PARAMETER);

            Log.d(getClass().getSimpleName()," ARGUMENTS - Parameter: "+parameter);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(PARAMETER, parameter);
        outState.putSerializable(DATA, data);

        Log.d(getClass().getSimpleName()," INSTANCE SAVED - Parameter: "+parameter+" | DATA: "+(data==null?"NULL":data.size()));
    }

    protected RecyclerView.LayoutManager createRecyclerViewLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    public String searchHint(){
        return "Pesquisar";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity ma = (MainActivity)getActivity();
        ma.getSupportActionBar().setDisplayHomeAsUpEnabled(enableBack());
        ma.getSupportActionBar().setDisplayShowHomeEnabled(enableBack());
        ma.getSupportActionBar().setTitle(createTitle());
        ma.getSupportActionBar().setSubtitle(createSubTitle());
        ma.setSearchVisible(enableSearch());
        ma.setSearchHint(searchHint());

        if(recyclerView!=null && adapter!=null){
            Log.d(getClass().getSimpleName()," onCreateView with components instances");
            return recyclerView;
        }
        Log.d(getClass().getSimpleName()," Creating components in onCreateView ");

        recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_simple_bean, container, false);
        recyclerView.setLayoutManager(createRecyclerViewLayoutManager());

        adapter = new SimpleBeanRecyclerViewAdapter<T>(new ArrayList<T>(), this){
            @Override
            public void setData(ArrayList data) {
                super.setData(data);
                AbstractFragment.this.data = data;
            }

            @Override
            public SimpleBeanViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
                return createHolder(inflater,parent);
            }
        };
        recyclerView.setAdapter(adapter);

        if(data == null){
            createData(adapter);
        }else{
            adapter.setData(data);
        }

        return recyclerView;
    }

    protected boolean enableSearch() {
        return true;
    }

    protected SimpleBeanViewHolder createHolder(LayoutInflater inflater, ViewGroup parent) {
        return new SimpleBeanViewHolder(inflater,parent);
    }

    protected boolean enableBack() {
        return true;
    }

    public void orderList(final String query) {
        recyclerView.scrollToPosition(0);
        adapter.orderBy(query);
        this.data = adapter.getData();
    }
}
