# Rede-social-de-atividades-locais
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "João", "joao@email.com", "senha123", localizacao);
        Atividade atividade = new Atividade(1, "Aula de Yoga", "Prática de yoga ao ar livre", "2023-11-25 10:00", localizacao);
        Grupo grupo = new Grupo(1, "Amantes do Yoga", usuario, "Grupo para praticantes de yoga");

        usuario.criar();
        usuario.publicarAtividade();

        atividade.criar();
        atividade.pesquisarAtividade();

        grupo.criar();
        grupo.publicarAtividadeGrupo();
    }
}
