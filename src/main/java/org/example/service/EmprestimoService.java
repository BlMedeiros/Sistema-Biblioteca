package org.example.service;

import org.example.repository.EmprestimoRepository;

import java.sql.SQLException;

public class EmprestimoService {

    EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
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
}
