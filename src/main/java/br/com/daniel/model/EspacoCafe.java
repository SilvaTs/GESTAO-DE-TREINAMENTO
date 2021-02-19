package br.com.daniel.model;

public class EspacoCafe {

    private int id;
    private String nome;
    private String lotacao;    
    private int sala_do_evento_id;
    
    public EspacoCafe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public int getSala_do_evento_id() {
        return sala_do_evento_id;
    }

    public void setSala_do_evento_id(int sala_do_evento_id) {
        this.sala_do_evento_id = sala_do_evento_id;
    }

    
}
