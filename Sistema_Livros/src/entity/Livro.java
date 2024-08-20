package entity;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Livro {

    private int idLivro;
    private String titulo;
    private Date anoPublicacao;
    private int idAutor;

    public int getId() {return idLivro;}
    public void setId(int id) {
        this.idLivro = id;
    }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Date getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public int getIdAutor() {return idAutor;}
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    //construtores

    public Livro() {
    }

    public Livro(int idLivro, String titulo, Date anoPublicacao, int idAutor) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Livro {" +
                "ID:" + idLivro +
                ", Titulo=" + titulo +
                ", Ano da Publicacao=" + anoPublicacao +
                ", Id do Autor=" + idAutor +
                '}';
    }
}
