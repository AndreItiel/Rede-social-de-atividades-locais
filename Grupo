import java.util.Scanner;
import java.util.ArrayList;

class Grupo implements Gerenciavel {
    private int id;
    private String nome;
    private ArrayList<Usuario> membros;
    private Usuario administrador;
    private String descricao;

    public Grupo(int id, String nome, Usuario administrador, String descricao) {
        this.id = id;
        this.nome = nome;
        this.administrador = administrador;
        this.descricao = descricao;
        this.membros = new ArrayList<>();
    }

    @Override
    public void criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do grupo:");
        this.nome = scanner.nextLine();
        System.out.println("Digite a descrição do grupo:");
        this.descricao = scanner.nextLine();

        System.out.println("Grupo criado!");
    }

    @Override
    public void editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o novo nome do grupo:");
        this.nome = scanner.nextLine();
        System.out.println("Digite a nova descrição do grupo:");
        this.descricao = scanner.nextLine();

        System.out.println("Grupo editado!");
    }

    @Override
    public void excluir() {
        System.out.println("Grupo excluído!");
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando detalhes do grupo");
    }

    public void adicionarMembro() {
        System.out.println("Membro adicionado ao grupo");
    }

    public void removerMembro() {
        System.out.println("Membro removido do grupo");
    }

    public void publicarAtividadeGrupo() {
        System.out.println("Atividade publicada no grupo");
    }

    public void comentarNoGrupo() {
        System.out.println("Comentando no grupo");
    }
}
