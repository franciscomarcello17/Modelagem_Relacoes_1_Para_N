package dao;

import entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorDAO extends BaseDAO {

    //CREATE
    public void inserir(Autor autor) {
        String sql = """
                insert into Autor (id, nome, nacionalidade)
                values (?, ?, ?);
                """;

        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setInt(1, autor.getId());
            pre.setString(2, autor.getNome());
            pre.setString(3, autor.getNacionalidade());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE
    public void atualizar(Autor autor) {
        String sql = """
                update Autor set nome = ?, nacionalidade = ?
                where id = ? ;
                """;
        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setString(1, autor.getNome());
            pre.setString(2, autor.getNacionalidade());
            pre.setInt(3, autor.getId());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DELETE
    public void deletar(Autor autor) {
        String sql = """
                delete from Autor where id = ? ;
                """;

        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setInt(1, autor.getId());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> obterTodos() {
        List<Autor> listaAutores = new ArrayList<>();
        String sql = """
                    select id
                          ,nome
                          ,nacionalidade
                     from Autor
                order by nome desc
                """;

        try (Connection c = con();
             PreparedStatement pre = c.prepareStatement(sql)) {
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Autor a = new Autor();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setNacionalidade(rs.getString("nacionalidade"));
                listaAutores.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAutores;
    }
}