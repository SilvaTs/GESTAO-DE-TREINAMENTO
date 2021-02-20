
package br.com.daniel.model;

public class Sala {
    
    private int id;
    private String nome;
    private String lotacao;    

    public Sala() {
        
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

    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + '}';
    }
    
        
}
