import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema!");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.print("Digite sua localização (cidade): ");
        String localizacao = scanner.nextLine();

        Perfil perfil = new Perfil(nome, email, senha, localizacao);

        Map<String, ArrayList<String>> gerenciamento = new HashMap<>();
        gerenciamento.put("Usuários", new ArrayList<>());
        gerenciamento.put("Atividades", new ArrayList<>());
        gerenciamento.put("Grupos", new ArrayList<>());
        gerenciamento.put("Comentários", new ArrayList<>());

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Atividades");
            System.out.println("3 - Gerenciar Grupos");
            System.out.println("4 - Gerenciar Comentários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarLista(gerenciamento.get("Usuários"), "Usuários", scanner);
                    break;
                case 2:
                    gerenciarLista(gerenciamento.get("Atividades"), "Atividades", scanner);
                    break;
                case 3:
                    gerenciarLista(gerenciamento.get("Grupos"), "Grupos", scanner);
                    break;
                case 4:
                    gerenciarLista(gerenciamento.get("Comentários"), "Comentários", scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Adeus!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void gerenciarLista(ArrayList<String> lista, String nomeLista, Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n=== Gerenciar " + nomeLista + " ===");
            System.out.println("1 - Adicionar elemento");
            System.out.println("2 - Remover elemento");
            System.out.println("3 - Mostrar " + nomeLista);
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Limpar o buffer do teclado
                    System.out.print("Digite o elemento a ser adicionado: ");
                    String elemento = scanner.nextLine();
                    lista.add(elemento);
                    System.out.println("Elemento adicionado à lista!");
                    break;
                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("A lista está vazia, não há elementos para remover!");
                    } else {
                        System.out.println("Lista atual: " + lista);
                        System.out.print("Digite o índice do elemento a ser removido: ");
                        int indice = scanner.nextInt();
                        if (indice >= 0 && indice < lista.size()) {
                            String removido = lista.remove(indice);
                            System.out.println("Elemento removido: " + removido);
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;
                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("A lista de " + nomeLista + " está vazia!");
                    } else {
                        System.out.println("Lista de " + nomeLista + ": " + lista);
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
