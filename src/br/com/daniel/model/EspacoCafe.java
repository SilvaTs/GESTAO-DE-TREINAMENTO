package br.com.daniel.model;

public class EspacoCafe {

    private int id;
    private String descricao;
    private String lotacao;    
    
    public EspacoCafe() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    @Override
    public String toString() {
        return "EspacoCafe{" + "descricao=" + descricao + '}';
    }

    
}
