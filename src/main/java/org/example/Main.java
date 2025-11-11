package org.example;

import org.example.repository.EmprestimoRepository;
import org.example.repository.LivroRepository;
import org.example.repository.UsuarioRepository;
import org.example.service.EmprestimoService;
import org.example.service.LivroService;
import org.example.service.UsuarioService;
import org.example.view.BibliotecaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LivroRepository livroRepository = new LivroRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

        LivroService livroService = new LivroService(livroRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository,livroRepository);

        BibliotecaView bibliotecaView = new BibliotecaView(sc,livroService,usuarioService,emprestimoService);
        while (bibliotecaView.mostrarMenu()) {

        }
    }
}