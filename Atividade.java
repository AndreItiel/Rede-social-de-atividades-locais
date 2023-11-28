import java.util.Scanner;
import java.util.ArrayList;
class Atividade implements Gerenciavel {
    private int id;
    private String titulo;
    private String descricao;
    private String dataHora;
    private Localizacao localizacao;
    private ArrayList<Comentario> comentarios;
    private int curtidas;
    private ArrayList<Usuario> participantes;

    public Atividade(int id, String titulo, String descricao, String dataHora, Localizacao localizacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.localizacao = localizacao;
        this.comentarios = new ArrayList<>();
        this.participantes = new ArrayList<>();
    }

    @Override
    public void criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o título da atividade:");
        this.titulo = scanner.nextLine();
        System.out.println("Digite a descrição da atividade:");
        this.descricao = scanner.nextLine();
        System.out.println("Digite a data e hora da atividade:");
        this.dataHora = scanner.nextLine();

        System.out.println("Atividade criada!");
    }

    @Override
    public void editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o novo título da atividade:");
        this.titulo = scanner.nextLine();
        System.out.println("Digite a nova descrição da atividade:");
        this.descricao = scanner.nextLine();
        System.out.println("Digite a nova data e hora da atividade:");
        this.dataHora = scanner.nextLine();

        System.out.println("Atividade editada!");
    }

    @Override
    public void excluir() {
        System.out.println("Atividade excluída!");
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando detalhes da atividade");
    }

    public void avaliarDetalhes() {
        System.out.println("Avaliando detalhes da atividade");
    }

    public void adicionarLocal() {
        System.out.println("Local adicionado à atividade");
    }

    public void receberNotificacao() {
        System.out.println("Recebendo notificação");
    }

    public void adicionarAmigo() {
        System.out.println("Amigo adicionado");
    }

    public void pesquisarAtividade() {
        System.out.println("Pesquisando atividade");
    }

    public void publicarAtividade() {
        System.out.println("Atividade publicada!");
    }
}
