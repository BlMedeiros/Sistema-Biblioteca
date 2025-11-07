package org.example.repository;

import org.example.infra.Conexao;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    public void inserirUsuario(Usuario usuario) throws SQLException {

        String insertQuery = """
                INSERT INTO usuarios
                (nome,email)
                VALUES
                (?,?)
                """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(insertQuery)) {

            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getEmail());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas>0) {
                System.out.println("Usuario Cadastrado com Sucesso!");
            }else {
                System.out.println("Não Foi Possivel Cadastrar o Usuario!");
            }
        }
    }

    public List<Usuario> listarUsuario() throws SQLException {

        List<Usuario> usuarioList = new ArrayList<>();

        String selectQuery = """
                SELECT id,nome,email
                FROM usuarios
                """;

        try(Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(selectQuery)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idUsuario =rs.getInt("id");
                String nomeUsuario = rs.getString("nome");
                String emailUsuario = rs.getString("email");

                usuarioList.add(new Usuario(idUsuario,nomeUsuario,emailUsuario));
            }
        }
        return usuarioList;
    }
}
