package  Projetin;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCRUD {

    private static final ArrayList<Produto> produtos = new ArrayList<>();
    private static int idAtual = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    editarProduto(scanner);
                    break;
                case 3:
                    deletarProduto(scanner);
                    break;
                case 4:
                    visualizarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("0 - Sair do sistema");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Editar produto");
        System.out.println("3 - Deletar produto");
        System.out.println("4 - Visualizar lista de produtos");
    }

    private static void cadastrarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Data de cadastro: ");
        String dataCadastro = scanner.nextLine();

        Produto novoProduto = new Produto(idAtual++, nome, quantidade, valor, dataCadastro);
        produtos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void editarProduto(Scanner scanner) {
        System.out.print("Digite o ID do produto a ser editado: ");
        int id = scanner.nextInt();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                System.out.print("Novo nome do produto: ");
                produto.setNome(scanner.next());
                System.out.print("Nova quantidade: ");
                produto.setQuantidade(scanner.nextInt());
                System.out.print("Novo valor: ");
                produto.setValor(scanner.nextDouble());
                scanner.nextLine(); 
                System.out.print("Nova data de cadastro: ");
                produto.setDataCadastro(scanner.nextLine());

                System.out.println("Produto editado com sucesso!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void deletarProduto(Scanner scanner) {
        System.out.print("Digite o ID do produto a ser deletado: ");
        int id = scanner.nextInt();

        produtos.removeIf(produto -> produto.getId() == id);

        System.out.println("Produto deletado com sucesso!");
    }

    private static void visualizarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}


