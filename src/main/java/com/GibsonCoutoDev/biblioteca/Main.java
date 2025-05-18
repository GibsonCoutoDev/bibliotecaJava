package com.GibsonCoutoDev.biblioteca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.Normalizer;

public class Main {

    static ArrayList<Livros> biblioteca = new ArrayList<>();
    static final String ARQUIVO_JSON = "livros.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        carregarLivros();

        do {
            System.out.println("Seja bem-vindo à minha Biblioteca");
            System.out.println("Menu:");
            System.out.println("1. Adicionar um livro");
            System.out.println("2. Remover um livro");
            System.out.println("3. Listar livros");
            System.out.println("4. Pesquisar livros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarLivro(scanner);
                    break;

                case 2:
                    removerLivro(scanner);
                    break;

                case 3:
                    listarLivros();
                    break;

                case 4:
                    System.out.print("Digite o termo de pesquisa: ");
                    String termo = scanner.nextLine();
                    pesquisarLivros(termo);
                    break;

                case 5:
                    salvarLivros();
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (escolha != 5);

        scanner.close();
    }

    public static void adicionarLivro(Scanner scanner) {
        Livros livro = new Livros();

        System.out.print("Digite o nome do Livro: ");
        livro.setNome(scanner.nextLine());
        System.out.print("Digite o nome do Autor: ");
        livro.setNomeAutor(scanner.nextLine());
        System.out.print("Digite a descrição do Livro: ");
        livro.setDescLivro(scanner.nextLine());
        System.out.print("Digite a categoria do Livro: ");
        livro.setCatLivro(scanner.nextLine());

        biblioteca.add(livro);
    }

    public static void removerLivro(Scanner scanner) {
        System.out.print("Digite o ID do Livro para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean livroRemovido = false;

        for (Livros livro : biblioteca) {
            if (livro.getId() == id) {
                biblioteca.remove(livro);
                livroRemovido = true;
                System.out.println("O Livro foi removido.");
                break;
            }
        }

        if (!livroRemovido) {
            System.out.println("O livro não foi encontrado.");
        }
    }

    public static void listarLivros() {
        if (biblioteca.isEmpty()) {
            System.out.println("Não há livros na biblioteca.");
        } else {
            System.out.println("Livros na biblioteca:");
            for (Livros livro : biblioteca) {
                livro.exibirInfos();
            }
        }
    }

    public static void salvarLivros() {
        try (FileWriter writer = new FileWriter(ARQUIVO_JSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(biblioteca, writer);
            System.out.println("Livros salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os livros: " + e.getMessage());
        }
    }

    public static void carregarLivros() {


        try (FileReader reader = new FileReader(ARQUIVO_JSON)) {
            Gson gson = new Gson();

            Type tipoListaLivros = new TypeToken<List<Livros>>(){}.getType();
            biblioteca = gson.fromJson(reader, tipoListaLivros);

            if (biblioteca == null) {
                biblioteca = new ArrayList<>();
            }
            int maiorId = 0;
            for (Livros livro : biblioteca) {
                if (livro.getId() > maiorId) {
                    maiorId = livro.getId();

                }
            }
            Livros.setContadorId(maiorId + 1);
            System.out.println("Livros carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os livros: " + e.getMessage());
        }
    }

    public static void pesquisarLivros(String termo){
        if (biblioteca == null || biblioteca.isEmpty()) {
            System.out.println("Não há livros com esse termo na biblioteca.");
            return;
        }

        boolean livroEncontrado = false;
        String termoFormatado = removerAcentos(termo).toLowerCase();

        for (Livros livro : biblioteca) {
            String nome = removerAcentos(livro.getNome().toLowerCase());
            String autor = removerAcentos(livro.getNomeAutor().toLowerCase());
            String desc = removerAcentos(livro.getDescLivro().toLowerCase());
            String categoria = removerAcentos(livro.getCatLivro().toLowerCase());

            if (nome.contains(termoFormatado) ||
                    autor.contains(termoFormatado) ||
                    desc.contains(termoFormatado) ||
                    categoria.contains(termoFormatado)) {

                livro.exibirInfos();
                System.out.println("-----------------------------");
                livroEncontrado = true;
            }
        }

        if (!livroEncontrado) {
            System.out.println("Nenhum livro encontrado com o termo: " + termo);
        }
    }

    public static String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return textoNormalizado.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
