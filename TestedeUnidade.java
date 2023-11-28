import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    @Test
    void testCriarAtividade() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);
        Atividade atividade = new Atividade(1, "Aula de Yoga", "Prática de yoga ao ar livre", "2023-11-25 10:00", localizacao);

        atividade.criar();

        assertEquals("Aula de Yoga", atividade.getTitulo());
        assertEquals("Prática de yoga ao ar livre", atividade.getDescricao());
        assertEquals("2023-11-25 10:00", atividade.getDataHora());
    }

    // Adicione mais métodos de teste conforme necessário
}

class LocalizacaoTest {

    @Test
    void testCriarLocalizacao() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");

        localizacao.criar();

        assertEquals(10.0, localizacao.getLatitude());
        assertEquals(20.0, localizacao.getLongitude());
        assertEquals("Rua XYZ", localizacao.getEndereco());
    }

    // Adicione mais métodos de teste conforme necessário
}

class UsuarioTest {

    @Test
    void testCriarUsuario() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);

        usuario.criar();

        assertEquals("Carlos", usuario.getNome());
        assertEquals("cadou@gmail.com", usuario.getEmail());
        assertEquals("senha123", usuario.getSenha());
    }

    // Adicione mais métodos de teste conforme necessário
}

class ComentarioTest {

    @Test
    void testCriarComentario() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);
        Comentario comentario = new Comentario(1, "Ótima atividade!", usuario, "2023-11-25 12:00");

        comentario.criar();

        assertEquals("Ótima atividade!", comentario.getTexto());
    }

    // Adicione mais métodos de teste conforme necessário
}

class GrupoTest {

    @Test
    void testCriarGrupo() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);
        Grupo grupo = new Grupo(1, "Grupo do Yoga", usuario, "Grupo para praticantes de yoga");

        grupo.criar();

        assertEquals("Grupo do Yoga", grupo.getNome());
        assertEquals("Grupo para praticantes de yoga", grupo.getDescricao());
    }

    // Adicione mais métodos de teste conforme necessário
}

class GerenciavelTest {

    @Test
    void testCriar() {
        Gerenciavel gerenciavel = new Atividade(1, "Aula de Yoga", "Prática de yoga ao ar livre", "2023-11-25 10:00", new Localizacao(10.0, 20.0, "Rua XYZ"));

        gerenciavel.criar();

        // Adicione as verificações necessárias conforme a lógica do seu programa
        // Por exemplo, você pode verificar se a criação foi bem-sucedida atribuindo valores esperados aos atributos da classe.

        assertEquals("Aula de Yoga", ((Atividade) gerenciavel).getTitulo());
        assertEquals("Prática de yoga ao ar livre", ((Atividade) gerenciavel).getDescricao());
        assertEquals("2023-11-25 10:00", ((Atividade) gerenciavel).getDataHora());
    }

    // Adicione mais métodos de teste conforme necessário
}
