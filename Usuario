import java.util.Scanner;
interface Gerenciavel {
    void criar();
    void editar();
    void excluir();
    void visualizar();
}

class Usuario implements Gerenciavel {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Localizacao localizacao;

    public Usuario(int id, String nome, String email, String senha, Localizacao localizacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.localizacao = localizacao;
    }

    @Override
    public void criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do usuário:");
        this.nome = scanner.nextLine();
        System.out.println("Digite o e-mail do usuário:");
        this.email = scanner.nextLine();
        System.out.println("Digite a senha do usuário:");
        this.senha = scanner.nextLine();

        System.out.println("Usuário criado!");
    }

    @Override
    public void editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o novo nome do usuário:");
        this.nome = scanner.nextLine();
        System.out.println("Digite a nova senha do usuário:");
        this.senha = scanner.nextLine();
        System.out.println("Usuário editado!");
    }

    @Override
    public void excluir() {
        System.out.println("Usuário excluído!");
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando perfil do usuário");
    }

    public void realizarBusca() {
        System.out.println("Realizando busca...");
    }

    public void gerenciarConta() {
        System.out.println("Gerenciando conta do usuário");
    }

    public void avaliarAtividade() {
        System.out.println("Avaliando atividade");
    }

    public void criarGrupo() {
        System.out.println("Grupo criado!");
    }

    public void interacaoSocial() {
        System.out.println("Interagindo socialmente");
    }

    public void publicarAtividade() {
        System.out.println("Atividade publicada!");
    }
}
