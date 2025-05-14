package com.GibsonCoutoDev;


public class Livros {
    private static int contadorId = 1;

    private String nome;
    private String nomeAutor;
    private String descLivro;
    private String catLivro;
    private int id;

    public Livros() {
        this.id = contadorId++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getDescLivro() {
        return descLivro;
    }

    public void setDescLivro(String descLivro) {
        this.descLivro = descLivro;
    }

    public String getCatLivro() {
        return catLivro;
    }

    public void setCatLivro(String catLivro) {
        this.catLivro = catLivro;
    }

    public int getId() {
        return id;
    }

    public void exibirInfos() {
        System.out.println("Nome do Livro: " + nome);
        System.out.println("Nome do Autor: " + nomeAutor);
        System.out.println("Categoria do Livro: " + catLivro);
        System.out.println("ID do Livro: " + id);
    }
}