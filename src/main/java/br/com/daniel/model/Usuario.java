package br.com.daniel.model;

public class Usuario {

    private int id;
    private String nome;
    private String sobreNome;
    

    public Usuario() {
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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + '}';
    }
    
    

}
