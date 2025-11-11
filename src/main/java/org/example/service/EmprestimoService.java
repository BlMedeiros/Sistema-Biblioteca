package org.example.service;

import org.example.model.Emprestimo;
import org.example.repository.EmprestimoRepository;
import org.example.repository.LivroRepository;

import java.sql.SQLException;
import java.util.List;

public class EmprestimoService {

    EmprestimoRepository emprestimoRepository;
    LivroRepository livroRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
    }

    public void inserirEmprestimo(int idLivro, int idUsuario) {
            if (idLivro == 0 || idUsuario == 0) {
                System.err.println("Os Identificadores Não Podem Ser Nulos");
            }else {
                try {
                    emprestimoRepository.inserirEmprestimo(idLivro,idUsuario);
                }catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        try {
            return emprestimoRepository.listarEmprestimos();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarEmprestimo(int idEmprestimo) {
        try {
            emprestimoRepository.atualizarEmprestimo(idEmprestimo);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
