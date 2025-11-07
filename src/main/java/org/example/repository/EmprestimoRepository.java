package org.example.repository;

import org.example.infra.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmprestimoRepository {

    public void inserirEmprestimo(int idLivro, int idUsuario) throws SQLException {
        String insertQuery = """
            INSERT INTO emprestimos
            (livro_id,usuario_id,data_emprestimo)
            VALUES(?,?,?)
            """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(insertQuery)) {

            stmt.setInt(1, idLivro);

            stmt.setInt(2, idUsuario);

            Date dataAtual = new Date(System.currentTimeMillis());
            stmt.setDate(3, dataAtual);

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0) {
                System.out.println("Empréstimo Cadastrado com Sucesso!");
            } else {
                System.out.println("Não Foi Possível Cadastrar o Empréstimo!");
            }
        }
    }
}
