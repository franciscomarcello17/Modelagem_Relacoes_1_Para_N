package entity;

import java.util.List;

public class Autor {

    private int id;
    private String nome;
    private String nacionalidade;
    private List<Livro> livros;

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id;}
    public String getNome() { return nome; }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public List<Livro> getLivro() { return livros;}

    public void setLivro(Livro livro) {
        this.livros.add(livro);
    }


    //construtores

    public Autor() {
    }

    public Autor(int id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id = " + id +
                ", nome = " + nome +
                ", nacionalidade = " + nacionalidade +
                '}';
    }
}
