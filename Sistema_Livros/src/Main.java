import dao.AutorDAO;
import dao.LivroDAO;
import entity.Autor;
import entity.Livro;
import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutorDAO autorDAO = new AutorDAO();
        LivroDAO livroDAO = new LivroDAO();
        int opcao;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Inserir Autor");
            System.out.println("2. Atualizar Autor");
            System.out.println("3. Excluir Autor");
            System.out.println("4. Listar Autores");
            System.out.println("5. Inserir Livro");
            System.out.println("6. Atualizar Livro");
            System.out.println("7. Excluir Livro");
            System.out.println("8. Listar Livros");
            System.out.println("9. Listar Livros de um Autor Específico");
            System.out.println("10. Finalizar Programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a quebra de linha

            switch (opcao) {
                //Inserir Autor
                case 1:
                    System.out.println("Inserir Autor:");
                    Autor novoAutor = new Autor();
                    System.out.print("ID: ");
                    novoAutor.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    novoAutor.setNome(scanner.nextLine());
                    System.out.print("Nacionalidade: ");
                    novoAutor.setNacionalidade(scanner.nextLine());
                    autorDAO.inserir(novoAutor);
                    System.out.println("Autor inserido com sucesso!");
                    break;

                //Atualizar Autor
                case 2:
                    System.out.println("Atualizar Autor:");
                    Autor autorAtualizado = new Autor();
                    System.out.print("ID: ");
                    autorAtualizado.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    autorAtualizado.setNome(scanner.nextLine());
                    System.out.print("Nacionalidade: ");
                    autorAtualizado.setNacionalidade(scanner.nextLine());
                    autorDAO.atualizar(autorAtualizado);
                    System.out.println("Autor atualizado com sucesso!");
                    break;

                //Excluir Autor
                case 3:
                    System.out.println("Excluir Autor:");
                    Autor autorParaExcluir = new Autor();
                    System.out.print("ID: ");
                    autorParaExcluir.setId(scanner.nextInt());
                    autorDAO.deletar(autorParaExcluir);
                    System.out.println("Autor excluído com sucesso!");
                    break;

                //Listar Autores
                case 4:
                    System.out.println("Listar Autores:");
                    List<Autor> autores = autorDAO.obterTodos();
                    for (Autor autor : autores) {
                        System.out.println(autor);
                    }
                    break;

                //Inserir Livro
                case 5:
                    System.out.println("Inserir Livro:");
                    Livro novoLivro = new Livro();
                    System.out.print("ID do Livro: ");
                    novoLivro.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Título: ");
                    novoLivro.setTitulo(scanner.nextLine());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdf.setLenient(false); // Configura o SimpleDateFormat para não aceitar datas inválidas
                    Date anoPublicacao = null;
                    // Loop para garantir a entrada correta
                    while (anoPublicacao == null) {
                        System.out.print("Ano de Publicação (formato yyyy-MM-dd): ");
                        String anoPublicacaoStr = scanner.nextLine();
                        try {
                            anoPublicacao = sdf.parse(anoPublicacaoStr);
                            novoLivro.setAnoPublicacao(anoPublicacao);
                        } catch (ParseException e) {
                            System.out.println("Formato de data inválido. Por favor, use o formato yyyy-MM-dd.");
                        }
                    }

                    System.out.print("ID do Autor: ");
                    novoLivro.setIdAutor(scanner.nextInt());
                    livroDAO.inserir(novoLivro);
                    System.out.println("Livro inserido com sucesso!");
                    break;

                //Atualizar Livro
                case 6:
                    System.out.println("Atualizar Livro:");
                    Livro livroAtualizado = new Livro();
                    System.out.print("ID do Livro: ");
                    livroAtualizado.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Título: ");
                    livroAtualizado.setTitulo(scanner.nextLine());

                    SimpleDateFormat sdfAtualizar = new SimpleDateFormat("yyyy-MM-dd");
                    sdfAtualizar.setLenient(false); // Configura o SimpleDateFormat para não aceitar datas inválidas
                    Date anoPublicacaoAtualizar = null;
                    // Loop para garantir a entrada correta
                    while (anoPublicacaoAtualizar == null) {
                        System.out.print("Ano de Publicação (formato yyyy-MM-dd): ");
                        String anoPublicacaoStr = scanner.nextLine();
                        try {
                            anoPublicacaoAtualizar = sdfAtualizar.parse(anoPublicacaoStr);
                            livroAtualizado.setAnoPublicacao(anoPublicacaoAtualizar);
                        } catch (ParseException e) {
                            System.out.println("Formato de data inválido. Por favor, use o formato yyyy-MM-dd.");
                        }
                    }

                    System.out.print("ID do Autor: ");
                    livroAtualizado.setIdAutor(scanner.nextInt());
                    livroDAO.atualizar(livroAtualizado);
                    System.out.println("Livro atualizado com sucesso!");
                    break;

                //Excluir Livro
                case 7:
                    System.out.println("Excluir Livro:");
                    Livro livroParaExcluir = new Livro();
                    System.out.print("ID do Livro: ");
                    livroParaExcluir.setId(scanner.nextInt());
                    livroDAO.deletar(livroParaExcluir);
                    System.out.println("Livro excluído com sucesso!");
                    break;

                //Listar Livros
                case 8:
                    System.out.println("Listar Livros:");
                    List<Livro> livros = livroDAO.obterTodos();
                    for (Livro livro : livros) {
                        System.out.println(livro);
                    }
                    break;

                case 9:
                    System.out.println("Listar Livros de um Autor Específico:");
                    System.out.print("ID do Autor: ");
                    int idAutor = scanner.nextInt();
                    List<Livro> livrosDoAutor = livroDAO.obterLivrosPorAutor(idAutor);
                    if (livrosDoAutor.isEmpty()) {
                        System.out.println("Não foram encontrados livros associados ao ID do autor informado.");
                    }
                    else {
                        for (Livro livro : livrosDoAutor) {
                            System.out.println(livro);
                        }
                    }
                    break;

                case 10:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 10);

        scanner.close();
    }
}
