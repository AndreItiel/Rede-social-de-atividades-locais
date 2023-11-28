import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);
        Atividade atividade = new Atividade(1, "Aula de Yoga", "Prática de yoga ao ar livre", "2023-11-25 10:00", localizacao);
        Grupo grupo = new Grupo(1, "Grupo do Yoga", usuario, "Grupo para praticantes de yoga");

        int escolha;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerenciar usuário");
            System.out.println("2. Gerenciar atividade");
            System.out.println("3. Gerenciar grupo");
            System.out.println("4. Sair");

            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                usuario.criar();
                usuario.publicarAtividade();
            } else if (escolha == 2) {
                atividade.criar();
                atividade.pesquisarAtividade();
            } else if (escolha == 3) {
                grupo.criar();
                grupo.publicarAtividadeGrupo();
            } else if (escolha == 4) {
                System.out.println("Saindo do programa. Até mais!");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 4);
    }
}