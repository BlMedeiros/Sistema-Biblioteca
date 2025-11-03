package org.example;

import org.example.repository.LivroRepository;
import org.example.service.LivroService;
import org.example.view.BibliotecaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LivroRepository livroRepository = new LivroRepository();
        LivroService livroService = new LivroService(livroRepository);

        BibliotecaView bibliotecaView = new BibliotecaView(sc,livroService);
        while (bibliotecaView.mostrarMenu()) {

        }
    }
}