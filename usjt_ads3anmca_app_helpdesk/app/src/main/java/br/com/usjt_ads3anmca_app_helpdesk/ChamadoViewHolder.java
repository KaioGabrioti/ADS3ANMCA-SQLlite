package br.com.usjt_ads3anmca_app_helpdesk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChamadoViewHolder extends RecyclerView.ViewHolder {

    public ImageView filaIconImageView;
    public TextView descricaoChamadoNaListTextView;
    public TextView statusChamadoTextView;
    public TextView dataAberturaTextView;
    public TextView dataFechamentoTextView;
    public ChamadoViewHolder (View raiz){
        super(raiz);

        filaIconImageView = raiz.findViewById(R.id.filaIconImageView);
        descricaoChamadoNaListTextView =
                raiz.findViewById(R.id.descricaoChamadoNaListTextView);
        statusChamadoTextView =
                raiz.findViewById(R.id.statusChamadoTextView);
        dataAberturaTextView = raiz.findViewById(R.id.dataAberturaTextView);
        dataFechamentoTextView = raiz.findViewById(R.id.dataFechamentoTextView);
    }
}
