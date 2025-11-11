package org.example.repository;

import org.example.infra.Conexao;
import org.example.model.Emprestimo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Emprestimo> listarEmprestimos() throws SQLException{

        List<Emprestimo> emprestimoList = new ArrayList<>();

        String selectQuery = """
                SELECT id,livro_id,usuario_id,data_emprestimo,data_devolucao
                FROM emprestimos
                WHERE data_devolucao IS NULL
                """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(selectQuery)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idLivro = rs.getInt("livro_id");
                int idUsuario = rs.getInt("usuario_id");
                java.util.Date data_emprestimo = rs.getDate("data_emprestimo");

                emprestimoList.add(new Emprestimo(id,idLivro,idUsuario,data_emprestimo));
            }
        }
        return emprestimoList;
    }

    public void atualizarEmprestimo(int idEmprestimo) throws SQLException{

        String updateQuery = """
                UPDATE emprestimos
                SET data_devolucao = ?
                WHERE id = ?
                """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(updateQuery)) {

            Date data = Date.valueOf(LocalDate.now());

            stmt.setDate(1,data);
            stmt.setInt(2,idEmprestimo);

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0) {
                System.out.println("Devolução Cadastrada com Sucesso!");
            } else {
                System.err.println("Ocorreu um Erro ao Cadastrar");
            }
        }
    }
}
