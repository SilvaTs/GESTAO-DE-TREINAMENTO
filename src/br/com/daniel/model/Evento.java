package br.com.daniel.model;

import java.util.Date;

public class Evento {

    private int id;
    private int etapa;
    private String intervalo;
    private int espaco_cafe_id;
    private int usuario_id;
    private int sala_id;
    
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

    public int getEspaco_cafe_id() {
        return espaco_cafe_id;
    }

    public void setEspaco_cafe_id(int espaco_cafe_id) {
        this.espaco_cafe_id = espaco_cafe_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getSala_id() {
        return sala_id;
    }

    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    @Override
    public String toString() {
        return "Evento{" + "espaco_cafe_id=" + espaco_cafe_id + ", usuario_id=" + usuario_id + ", sala_id=" + sala_id + '}';
    }

   
}
