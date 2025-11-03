package org.example.service;

import org.example.model.Livro;
import org.example.repository.LivroRepository;

public class LivroService {

    LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void inserirLivro(String titulo, String autor, int ano) {
        if(titulo.isBlank() || autor.isBlank() || ano <= 0) {
            throw new RuntimeException("As Informações do Livro Não Podem Ser Nulas!");
        }

        try {
            Livro livro = new Livro(titulo,autor,ano);

            livroRepository.inserirLivro(livro);
        }catch(RuntimeException e) {
            System.err.println("Ocorreu um Erro ao Inserir o Livro no Banco de Dados: " + e.getMessage());
            e.printStackTrace();

            throw new RuntimeException("Ocorreu um Erro Interno ao Cadastrar no Banco de Dados");
        }

    }
}
