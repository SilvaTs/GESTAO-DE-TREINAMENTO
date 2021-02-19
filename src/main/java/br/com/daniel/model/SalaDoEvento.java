package br.com.daniel.model;

import java.util.Date;

public class SalaDoEvento {

    private int id;
    private String nome;
    private String lotacao;
    private Date primeiroIntervalo;
    private Date segundoIntervalo;
    private int etapas;
    private int usuario_id;
    
    public SalaDoEvento() {
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

    public Date getPrimeiroIntervalo() {
        return primeiroIntervalo;
    }

    public void setPrimeiroIntervalo(Date primeiroIntervalo) {
        this.primeiroIntervalo = primeiroIntervalo;
    }

    public Date getSegundoIntervalo() {
        return segundoIntervalo;
    }

    public void setSegundoIntervalo(Date segundoIntervalo) {
        this.segundoIntervalo = segundoIntervalo;
    }

    public int getEtapas() {
        return etapas;
    }

    public void setEtapas(int etapas) {
        this.etapas = etapas;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
   
   
    
    

}
