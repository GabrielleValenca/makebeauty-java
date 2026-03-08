import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MakeBeautyDAO makeDAO = new MakeBeautyDAO();
        Carrinho carrinho = new Carrinho();

        int opcao;

        do {
            System.out.println("\n=== SISTEMA MAKEBEAUTY ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Deletar Produto");
            System.out.println("4 - Alterar Produto");
            System.out.println("5 - Adicionar Produto ao Carrinho");
            System.out.println("6 - Mostrar Carrinho");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {

                case 1 -> {
                    System.out.println("\n--- CADASTRAR PRODUTO ---");

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Nome do Produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    System.out.print("Data validade (AAAA-MM-DD): ");
                    LocalDate data = LocalDate.parse(sc.next());

                    // cadastra na classe mãe
                    MakeBeauty novo = new MakeBeautyDados(0, marca, nome, preco, data);
                    makeDAO.inserir(novo);

                    System.out.println("Produto cadastrado com sucesso! ID: " + novo.getId());
                }

                case 2 -> {
                    System.out.println("\n--- LISTA DE PRODUTOS ---");
                    for (MakeBeautyDados m : makeDAO.listar()) {
                        System.out.println("ID: " + m.getId() +
                                " | " + m.getNomeProduto() +
                                " | R$ " + m.getPreco());
                    }
                }

                case 3 -> {
                    System.out.print("\nID do produto a deletar: ");
                    int idDel = sc.nextInt();
                    makeDAO.deletar(idDel);
                    System.out.println("Produto deletado.");
                }

                case 4 -> {
                    System.out.println("\n--- ALTERAR PRODUTO ---");

                    System.out.print("ID do produto: ");
                    int idA = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nova marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Novo preço: ");
                    double preco = sc.nextDouble();

                    System.out.print("Nova validade (AAAA-MM-DD): ");
                    LocalDate data = LocalDate.parse(sc.next());

                    MakeBeauty m = new MakeBeautyDados(idA, marca, nome, preco, data);

                    makeDAO.atualizar(m);

                    System.out.println("Produto atualizado.");
                }

                case 5 -> {
                    System.out.print("\nDigite o ID do produto para adicionar ao carrinho: ");
                    int idCarrinho = sc.nextInt();

                    // buscar produto
                    MakeBeauty item = null;
                    for (MakeBeautyDados m : makeDAO.listar()) {
                        if (m.getId() == idCarrinho) {
                            item = m;
                            break;
                        }
                    }

                    if (item != null) {
                        carrinho.adicionar(item);
                        System.out.println("Produto adicionado ao carrinho!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                }

                case 6 -> {
                    System.out.println("\n--- CARRINHO ---");
                    carrinho.mostrarCarrinho();
                    System.out.println("Total: R$ " + carrinho.total());
                }

                case 0 -> System.out.println("\nSaindo...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
