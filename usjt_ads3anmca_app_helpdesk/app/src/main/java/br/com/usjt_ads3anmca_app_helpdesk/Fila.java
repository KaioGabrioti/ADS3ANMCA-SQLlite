package br.com.usjt_ads3anmca_app_helpdesk;

import java.io.Serializable;
import java.util.List;

class Fila implements Serializable {
    private int id;
    private String nome;
    private int iconId;

    public Fila (String nome, int iconId){
        this(0, nome, iconId);
    }

    public Fila (int id, String nome, int iconId){
        setId(id);
        setNome(nome);
        setIconId(iconId);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<Chamado> chamados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
