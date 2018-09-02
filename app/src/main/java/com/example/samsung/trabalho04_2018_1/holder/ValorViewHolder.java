package com.example.samsung.trabalho04_2018_1.holder;

import android.widget.TextView;

import com.example.samsung.trabalho04_2018_1.R;
import com.example.samsung.trabalho04_2018_1.model.Valor;

public class ValorViewHolder {extends SimpleBeanViewHolder<Valor>{

    private static final String GOOGLE_IMG_URL = "https://www.google.com/search?site=&tbm=isch&q=";

    public final TextView tvValor;
    public final TextView tvReferencia;
    public final TextView tvCodigoFipe;
    public final TextView tvMarca;
    public final TextView tvCombustivel;
    public final TextView tvAno;
    private AdvancedWebView mWebView;
    private String imgUrl;

    public ValorViewHolder(View view) {
        super(view);
        tvValor = (TextView) view.findViewById(R.id.tvValor);
        tvReferencia = (TextView) view.findViewById(R.id.tvReferencia);
        tvCodigoFipe = (TextView) view.findViewById(R.id.tvCodigoFipe);
        tvCombustivel = (TextView) view.findViewById(R.id.tvCombustivel);
        tvMarca = (TextView) view.findViewById(R.id.tvMarca);
        tvAno = (TextView) view.findViewById(R.id.tvAno);
        //mWebView = (AdvancedWebView) view.findViewById(R.id.webview);
    }

    public ValorViewHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.item_valor, parent, false));
    }

    @Override
    public void onBindViewHolder(Valor item) {
        super.onBindViewHolder(item);
        tvValor.setText(item.getValor());
        tvReferencia.setText(item.getReferencia());
        tvCodigoFipe.setText(item.getFipeCodigo());
        tvMarca.setText(item.getMarca());
        tvCombustivel.setText(item.getCombustivel());
        tvAno.setText(item.isZeroKm()?"ZERO KM":item.getAnoModelo()+"");
        //imgUrl = GOOGLE_IMG_URL+item.getMarca()+" "+item.getName()+(item.isZeroKm()?"":" "+item.getAnoModelo());
        //mWebView.loadUrl(imgUrl);
    }
}
