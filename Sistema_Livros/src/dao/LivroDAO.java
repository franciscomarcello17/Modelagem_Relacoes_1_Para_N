package dao;
import entity.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAO extends BaseDAO {

    //CREATE
    public void inserir(Livro livro) {
        String sql = """
                insert into Livro (idLivro, titulo, anoPublicacao, idAutor)
                values (?, ?, ?, ?);
                """;

        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setInt(1, livro.getId());
            pre.setString(2, livro.getTitulo());
            pre.setDate(3, (Date) livro.getAnoPublicacao());
            pre.setInt(4, livro.getIdAutor());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE
    public void atualizar(Livro livro) {
        String sql = """
                update Livro set titulo = ?, anoPublicacao = ?, idAutor = ?
                where idLivro = ? ;
                """;
        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setString(1, livro.getTitulo());
            pre.setDate(2, (Date) livro.getAnoPublicacao());
            pre.setInt(3, livro.getIdAutor());
            pre.setInt(4, livro.getId());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DELETE
    public void deletar(Livro livro) {
        String sql = """
                delete from Livro where idLivro = ? ;
                """;

        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setInt(1, livro.getId());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> obterTodos() {
        List<Livro> listaLivros = new ArrayList<>();
        String sql = """
                    select idLivro
                          ,titulo
                          ,anoPublicacao
                          ,idAutor
                     from Livro
                order by idLivro ASC;
                """;

        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("idLivro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAnoPublicacao(rs.getDate("anoPublicacao"));
                l.setIdAutor(rs.getInt("idAutor"));
                listaLivros.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaLivros;
    }

    public List<Livro> obterLivrosPorAutor(int idAutor) {
        List<Livro> listaLivros = new ArrayList<>();
        String sql = """
                SELECT idLivro, titulo, anoPublicacao, idAutor
                FROM Livro
                WHERE idAutor = ?;
                """;

        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setInt(1, idAutor);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAnoPublicacao(rs.getDate("anoPublicacao"));
                livro.setIdAutor(rs.getInt("idAutor"));
                listaLivros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaLivros;
    }

}