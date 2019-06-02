package br.com.usjt_ads3anmca_app_helpdesk;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Chamado implements Serializable {
    private Fila fila;
    private String descricao;
    private Date dataAbertura;
    private Date dataFechamento;
    private String status;

    public Chamado (Fila f, String d,
                    Date dAb, Date dFec, String st){
        setFila(f);
        setDescricao(d);
        setDataAbertura(dAb);
        setDataFechamento(dFec);
        setStatus(st);
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    @Override
    public String toString() {
        //return getFila().getNome() + ":" + this.getDescricao();
        return String.format(
                "%s:%s",
                getFila().getNome(),
                getDescricao()
        );
    }
}
