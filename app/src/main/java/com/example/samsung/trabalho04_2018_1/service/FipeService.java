package com.example.samsung.trabalho04_2018_1.service;

import com.example.samsung.trabalho04_2018_1.model.Marca;
import com.example.samsung.trabalho04_2018_1.model.Modelo;
import com.example.samsung.trabalho04_2018_1.model.Tipo;
import com.example.samsung.trabalho04_2018_1.model.Valor;
import com.example.samsung.trabalho04_2018_1.model.Veiculo;
import com.example.samsung.trabalho04_2018_1.view.MainActivity;

import org.json.JSONObject;

import java.util.ArrayList;

public class FipeService {

        private static final String BASE_URL = "http://fipeapi.appspot.com/api/1/";
        private MainActivity activity;

    public FipeService(MainActivity activity){
        this.activity = activity;
    }

        public void getMarcas(final Tipo tipo, final ServiceCallback<ArrayList<Marca>> callback) {

        new FipeAsyncTask<Marca>(activity,callback){
            @Override
            public String createURL() {
                return BASE_URL + tipo.getTipo()+"/marcas.json";
            }
            @Override
            public Marca createBean(JSONObject obj) throws Exception {
                return new Marca(obj.getString("id"), obj.getString("name"), tipo);
            }
        }.execute();
    }

        public void getVeiculos(final Marca marca, final ServiceCallback<ArrayList<Veiculo>> callback) {

        new FipeAsyncTask<Veiculo>(activity,callback){
            @Override
            public String createURL() {
                return BASE_URL + marca.getTipo().getTipo()+"/veiculos/"+marca.getId()+".json";
            }
            @Override
            public Veiculo createBean(JSONObject obj) throws Exception {
                return new Veiculo(obj.getString("id"), obj.getString("name"), marca);
            }
        }.execute();
    }

        public void getModelos(final Veiculo veiculo, final ServiceCallback<ArrayList<Modelo>> callback) {

        new FipeAsyncTask<Modelo>(activity,callback){
            @Override
            public String createURL() {
                return BASE_URL + veiculo.getMarca().getTipo().getTipo()+"/veiculo/"+
                        veiculo.getMarca().getId()+"/"+veiculo.getId()+".json";
            }
            @Override
            public Modelo createBean(JSONObject obj) throws Exception {
                return new Modelo(obj.getString("id"), obj.getString("name"), veiculo);
            }
        }.execute();
    }

        public void getPreco(final Modelo modelo, final ServiceCallback<ArrayList<Valor>> callback) {

        new FipeAsyncTask<Valor>(activity,callback){
            @Override
            public String createURL() {
                return BASE_URL + modelo.getVeiculo().getMarca().getTipo().getTipo()+"/veiculo/"+
                        modelo.getVeiculo().getMarca().getId()+"/"+modelo.getVeiculo().getId()+"/"+modelo.getId()+".json";
            }
            @Override
            public Valor createBean(JSONObject obj) throws Exception {
                Valor valor = new Valor();
                valor.setModelo(modelo);

                valor.setId(obj.getString("id"));
                valor.setNome(obj.getString("nome"));
                valor.setValor(obj.getString("valor"));
                valor.setCombustivel(obj.getString("combustivel"));
                valor.setFipeCodigo(obj.getString("fipe_codigo"));
                valor.setMarca(obj.getString("marca"));
                valor.setReferencia(obj.getString("referencia"));
                valor.setKey(obj.getString("key"));
                valor.setAnoModelo(obj.getInt("ano_modelo"));

                return valor;
            }
        }.execute();
    }
}
