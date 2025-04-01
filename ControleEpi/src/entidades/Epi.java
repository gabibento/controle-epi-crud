package entidades;

public class Epi {
    private int id;
    private static int incrementador;
    private String nome;
    private int quantidade;

    public Epi(String nome, int quantidade) {
        this.id = incrementador++;
        this.nome = nome;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
