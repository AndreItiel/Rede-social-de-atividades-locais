import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    @Test
    void testCriarAtividade() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);
        Atividade atividade = new Atividade(1, "Aula de Yoga", "Prática de yoga ao ar livre", "2023-11-25 10:00", localizacao);

        atividade.criar();

        Assertions.assertEquals("Aula de Yoga", atividade.getTitulo());
        Assertions.assertEquals("Prática de yoga ao ar livre", atividade.getDescricao());
        Assertions.assertEquals("2023-11-25 10:00", atividade.getDataHora());
    }

    
}

class LocalizacaoTest {

    @Test
    void testCriarLocalizacao() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");

        localizacao.criar();

        Assertions.assertEquals(10.0, localizacao.getLatitude());
        Assertions.assertEquals(20.0, localizacao.getLongitude());
        Assertions.assertEquals("Rua XYZ", localizacao.getEndereco());
    }

    
}

class UsuarioTest {

    @Test
    void testCriarUsuario() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);

        usuario.criar();

        Assertions.assertEquals("Carlos", usuario.getNome());
        Assertions.assertEquals("cadou@gmail.com", usuario.getEmail());
        Assertions.assertEquals("senha123", usuario.getSenha());
    }

    
}

class ComentarioTest {

    @Test
    void testCriarComentario() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);
        Comentario comentario = new Comentario(1, "Ótima atividade!", usuario, "2023-11-25 12:00");

        comentario.criar();

        Assertions.assertEquals("Ótima atividade!", comentario.getTexto());
    }

    
}

class GrupoTest {

    @Test
    void testCriarGrupo() {
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua XYZ");
        Usuario usuario = new Usuario(1, "Carlos", "cadou@gmail.com", "senha123", localizacao);
        Grupo grupo = new Grupo(1, "Grupo do Yoga", usuario, "Grupo para praticantes de yoga");

        grupo.criar();

        Assertions.assertEquals("Grupo do Yoga", grupo.getNome());
        Assertions.assertEquals("Grupo para praticantes de yoga", grupo.getDescricao());
    }

    
}

class GerenciavelTest {

    @Test
    void testCriar() {
        Gerenciavel gerenciavel = new Atividade(1, "Aula de Yoga", "Prática de yoga ao ar livre", "2023-11-25 10:00", new Localizacao(10.0, 20.0, "Rua XYZ"));

        gerenciavel.criar();

        

        Assertions.assertEquals("Aula de Yoga", ((Atividade) gerenciavel).getTitulo());
        Assertions.assertEquals("Prática de yoga ao ar livre", ((Atividade) gerenciavel).getDescricao());
        Assertions.assertEquals("2023-11-25 10:00", ((Atividade) gerenciavel).getDataHora());
    }

    
}

