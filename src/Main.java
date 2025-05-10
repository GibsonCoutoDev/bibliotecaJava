import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<livros> biblioteca = new ArrayList<>();

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
        livros livro = new livros();

        System.out.print("Digite o nome do Livro: ");
        livro.nome = scanner.nextLine();
        System.out.print("Digite o nome do Autor: ");
        livro.nomeAutor = scanner.nextLine();
        System.out.print("Digite a descrição do Livro: ");
        livro.descLivro = scanner.nextLine();
        System.out.print("Digite a categoria do Livro: ");
        livro.catLivro = scanner.nextLine();
        biblioteca.add(livro);
    }

    public static void removerLivro(Scanner scanner) {
        System.out.print("Digite o ID do Livro para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean livroRemovido = false;

        for (livros livro : biblioteca) {
            if (livro.id == id) {
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
            for (livros livro : biblioteca) {
                System.out.println("ID: " + livro.id + " | Nome: " + livro.nome + " | Autor: " + livro.nomeAutor);
            }
        }
    }
}
