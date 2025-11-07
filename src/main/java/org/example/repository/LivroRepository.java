package org.example.repository;

import org.example.infra.Conexao;
import org.example.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    public void inserirLivro(Livro livro) throws SQLException {
        String insertQuery = """
                INSERT INTO livros(
                titulo,autor,ano)
                VALUES(?,?,?)
                """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(insertQuery)) {

            stmt.setString(1,livro.getTitulo());
            stmt.setString(2,livro.getAutor());
            stmt.setInt(3,livro.getAno());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas>0) {
                System.out.println("Livro Cadastrado com Sucesso!");
            }else {
                System.out.println("Não Foi Possivel Cadastrar o Livro!");
            }
        }
    }

    public List<Livro> listarLivro() throws SQLException {
        List<Livro> livrosList = new ArrayList<>();

        String selectQuery = """
                SELECT id,titulo,autor,ano,disponivel
                FROM livros
                """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(selectQuery)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idLivro = rs.getInt("id");
                String tituloLivro = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano");
                Boolean disponivel = rs.getBoolean("disponivel");

                livrosList.add(new Livro(idLivro,tituloLivro,autor,ano,disponivel));
            }
        }
        return livrosList;
    }

    public void atualizarStatusLivro(int idLivro, boolean disponivel) throws SQLException {

        String updateQuery = """
                UPDATE livros
                SET disponivel = ?
                WHERE id = ?
                """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(updateQuery)) {

            stmt.setBoolean(1,disponivel);
            stmt.setInt(2,idLivro);

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas>0) {
                System.out.println("Livro Atualizado com Sucesso!");
            }else {
                System.out.println("Não Foi Possivel Atualizar o Livro!");
            }
        }
    }
}
