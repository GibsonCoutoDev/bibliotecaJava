import java.sql.SQLOutput;
public class livros {
    private static int contadorId = 1;

    String nome;
    String nomeAutor;
    String descLivro;
    String catLivro;
    int id;

    public livros() {
        this.id = contadorId++;
    }

    public void exibirInfos() {
        System.out.println("Nome do Livro: " + nome);
        System.out.println("Nome do Autor: " + nomeAutor);
        System.out.println("Categoria do Livro: " + catLivro);
        System.out.println("ID do Livro: " + id);


    }
}


