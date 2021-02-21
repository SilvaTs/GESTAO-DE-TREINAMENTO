
package br.com.daniel.model;

public class Sala {
    
    private int id;
    private String nome;
    private int lotacao;    

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

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + '}';
    }
    
        
}
