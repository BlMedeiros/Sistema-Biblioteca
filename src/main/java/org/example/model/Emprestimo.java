package org.example.model;

import java.time.Year;
import java.util.Date;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private Date data_emprestimo;
    private Date data_devolucao;

    public Emprestimo(int id, Livro livro, Usuario usuario, Date data_emprestimo, Date data_devolucao) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimo(Livro livro, Usuario usuario, Date data_emprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.data_emprestimo = data_emprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
