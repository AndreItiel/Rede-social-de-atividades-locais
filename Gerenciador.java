import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
    public static void main(String[] args) {
        ArrayList<String> usuarios = new ArrayList<>();
        ArrayList<String> atividades = new ArrayList<>();
        ArrayList<String> grupos = new ArrayList<>();
        ArrayList<String> comentarios = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
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
                    gerenciarLista(usuarios, "Usuários", scanner);
                    break;
                case 2:
                    gerenciarLista(atividades, "Atividades", scanner);
                    break;
                case 3:
                    gerenciarLista(grupos, "Grupos", scanner);
                    break;
                case 4:
                    gerenciarLista(comentarios, "Comentários", scanner);
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
