package br.com.usjt_ads3anmca_app_helpdesk;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChamadoRecyclerViewAdapter
        extends RecyclerView.Adapter <ChamadoViewHolder>{

    private List<Chamado> chamados;

    public ChamadoRecyclerViewAdapter (List <Chamado> chamados){
        this.chamados = chamados;
    }

    @NonNull
    @Override
    public ChamadoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =
                LayoutInflater.from(viewGroup.getContext());
        View raiz =
                inflater.inflate(R.layout.item_de_lista, viewGroup, false);
        return new ChamadoViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamadoViewHolder vh, int i) {
        Chamado chamado = chamados.get(i);
        vh.filaIconImageView.setImageResource(chamado.getFila().getIconId());
        vh.descricaoChamadoNaListTextView.setText(chamado.getDescricao());
        vh.statusChamadoTextView.setText(chamado.getStatus());
        vh.dataAberturaTextView.setText(DateHelper.format(chamado.getDataAbertura()));
        if (chamado.getDataFechamento() != null)
            vh.dataFechamentoTextView.setText(DateHelper.format(chamado.getDataFechamento()));

    }

    @Override
    public int getItemCount() {
        return chamados.size();
    }
}
