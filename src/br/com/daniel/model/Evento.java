package br.com.daniel.model;


public class Evento {

    private int id;
    private int etapa;
    private String intervalo;
    private EspacoCafe espacoCafe;
    private Sala sala;
    private Usuario usuario;
    
    public Evento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public EspacoCafe getEspacoCafe() {
        return espacoCafe;
    }

    public void setEspacoCafe(EspacoCafe espacoCafe) {
        this.espacoCafe = espacoCafe;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
   
}
