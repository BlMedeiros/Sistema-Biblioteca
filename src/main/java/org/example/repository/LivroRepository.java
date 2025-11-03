package org.example.repository;

import org.example.infra.Conexao;
import org.example.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroRepository {

    public void inserirLivro(Livro livro) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
