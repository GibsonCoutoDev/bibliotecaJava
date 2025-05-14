
package com.gibsoncoutodev.biblioteca;
import com.GibsonCoutoDev.Livros;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Scanner;

public class Main {

    static ArrayList<Livros> biblioteca = new ArrayList<>();
    static final String ARQUIVO_JSON = "livros.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Seja bem vindo a minha Biblioteca");
            System.out.println("Menu:");
            System.out.println("1. Adicionar um livro");
            System.out.println("2. Remover um livro");
            System.out.println("3. Listar livros");
            System.out.println("4. Sair");
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
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (escolha != 4);

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
}
