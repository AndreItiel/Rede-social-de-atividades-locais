import java.util.Scanner;
class Comentario implements Gerenciavel {
    private int id;
    private String texto;
    private Usuario autor;
    private String dataHora;

    public Comentario(int id, String texto, Usuario autor, String dataHora) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.dataHora = dataHora;
    }

    @Override
    public void criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o texto do comentário:");
        this.texto = scanner.nextLine();

        System.out.println("Comentário adicionado!");
    }

    @Override
    public void editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o novo texto do comentário:");
        this.texto = scanner.nextLine();

        System.out.println("Comentário editado!");
    }

    @Override
    public void excluir() {
        System.out.println("Comentário excluído!");
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando comentário");
    }
}
