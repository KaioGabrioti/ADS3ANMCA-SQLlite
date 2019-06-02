package br.com.usjt_ads3anmca_app_helpdesk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChamadoArrayAdapter extends ArrayAdapter <Chamado> {


    private class ViewHolder{
        public ImageView filaIconImageView;
        public TextView descricaoChamadoNaListTextView;
        public TextView statusChamadoTextView;
        public TextView dataAberturaTextView;
        public TextView dataFechamentoTextView;
    }

    public ChamadoArrayAdapter (Context context, List<Chamado> chamados){
        super(context, -1, chamados);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            LayoutInflater inflater =
                    LayoutInflater.from(getContext());
            convertView =
                    inflater.inflate(R.layout.item_de_lista, parent, false);
            vh = new ViewHolder();
            vh.filaIconImageView = convertView.findViewById(R.id.filaIconImageView);
            vh.descricaoChamadoNaListTextView = convertView.findViewById(R.id.descricaoChamadoNaListTextView);
            vh.statusChamadoTextView = convertView.findViewById(R.id.statusChamadoTextView);
            vh.dataAberturaTextView = convertView.findViewById(R.id.dataAberturaTextView);
            vh.dataFechamentoTextView = convertView.findViewById(R.id.dataFechamentoTextView);
            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();
        Chamado chamadoDaVez = getItem(position);

        vh.filaIconImageView.setImageResource(
                chamadoDaVez.
                        getFila().
                        getIconId()
        );
        vh.descricaoChamadoNaListTextView.setText(chamadoDaVez.getDescricao());
        vh.dataAberturaTextView.
                setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if (chamadoDaVez.getDataFechamento() != null){
            vh.dataFechamentoTextView.setText(
                    DateHelper.format(chamadoDaVez.getDataFechamento())
            );
        }
        vh.statusChamadoTextView.setText(chamadoDaVez.getStatus());
        return convertView;
    }
}
