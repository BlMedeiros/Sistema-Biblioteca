package org.example.service;

import org.example.model.Livro;
import org.example.repository.LivroRepository;

import java.sql.SQLException;
import java.util.List;

public class LivroService {

    LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void inserirLivro(String titulo, String autor, int ano) {
        if (titulo.isBlank() || autor.isBlank() || ano <= 0) {
            System.err.println("As Informações do Livro Não Podem Ser Nulas!");
        } else {
            try {
                Livro livro = new Livro(titulo, autor, ano);

                livroRepository.inserirLivro(livro);
            } catch (RuntimeException e) {
                System.err.println("Ocorreu um Erro ao Inserir o Livro no Banco de Dados: " + e.getMessage());
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Livro> listarLivro() {
        try {
            List<Livro> livroList = livroRepository.listarLivro();

            return livroList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarStatusLivro(int idLivro) {
        if(idLivro == 0 ) {
            System.err.println("As Informações do Livro Não Podem Ser Nulas!");
        } else {
            try {
                livroRepository.atualizarStatusLivro(idLivro,false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
