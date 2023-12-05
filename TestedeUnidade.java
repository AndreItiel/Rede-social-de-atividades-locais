import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;import static 

org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void testeFluxoPrincipal() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "John Doe\njohn@example.com\npassword\nCity\n2\n1\nJohn's Activity\nDescription\n2023-01-01\n0\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Executar o método main da classe
            Main.main(new String[]{});

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Bem-vindo ao sistema!\n" +
                    "Digite seu nome: Digite seu e-mail: Digite sua senha: Digite sua localização (cidade): \n" +
                    "\n=== MENU ===\n" +
                    "1 - Gerenciar Usuários\n" +
                    "2 - Gerenciar Atividades\n" +
                    "3 - Gerenciar Grupos\n" +
                    "4 - Gerenciar Comentários\n" +
                    "0 - Sair\n" +
                    "Escolha uma opção: \n" +
                    "\n=== Gerenciar Atividades ===\n" +
                    "1 - Adicionar elemento\n" +
                    "2 - Remover elemento\n" +
                    "3 - Mostrar Atividades\n" +
                    "0 - Voltar ao menu principal\n" +
                    "Escolha uma opção: Atividade adicionada à lista!\n" +
                    "Voltando ao menu principal.\n" +
                    "\n=== MENU ===\n" +
                    "1 - Gerenciar Usuários\n" +
                    "2 - Gerenciar Atividades\n" +
                    "3 - Gerenciar Grupos\n" +
                    "4 - Gerenciar Comentários\n" +
                    "0 - Sair\n" +
                    "Escolha uma opção: \n" +
                    "Saindo do programa. Adeus!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }
}

class UsuarioTest {

    @Test
    void getNome() {
        Usuario usuario = new Usuario("NomeTeste", "email@teste.com", "senhaTeste", "CidadeTeste");
        assertEquals("NomeTeste", usuario.getNome());
    }

    @Test
    void getEmail() {
        Usuario usuario = new Usuario("NomeTeste", "email@teste.com", "senhaTeste", "CidadeTeste");
        assertEquals("email@teste.com", usuario.getEmail());
    }

    @Test
    void getSenha() {
        Usuario usuario = new Usuario("NomeTeste", "email@teste.com", "senhaTeste", "CidadeTeste");
        assertEquals("senhaTeste", usuario.getSenha());
    }

    @Test
    void getLocalizacao() {
        Usuario usuario = new Usuario("NomeTeste", "email@teste.com", "senhaTeste", "CidadeTeste");
        assertEquals("CidadeTeste", usuario.getLocalizacao());
    }
}

    @Test
    void criar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "10.0\n20.0\nRua 123\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Localizacao
            Localizacao localizacao = new Localizacao();
            localizacao.criar();

            // Verificar se a instância foi criada corretamente
            assertEquals(10.0, localizacao.getLatitude(), 0.001);
            assertEquals(20.0, localizacao.getLongitude(), 0.001);
            assertEquals("Rua 123", localizacao.getEndereco());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite a latitude da localização:\nDigite a longitude da localização:\nDigite o endereço da localização:\nLocalização adicionada!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void editar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "30.0\n40.0\nNova Rua\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Localizacao
            Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
            localizacao.editar();

            // Verificar se a instância foi editada corretamente
            assertEquals(30.0, localizacao.getLatitude(), 0.001);
            assertEquals(40.0, localizacao.getLongitude(), 0.001);
            assertEquals("Nova Rua", localizacao.getEndereco());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite a nova latitude da localização:\nDigite a nova longitude da localização:\nDigite o novo endereço da localização:\nLocalização editada!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void excluir() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Localizacao
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        localizacao.excluir();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Localização excluída!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void visualizar() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Localizacao
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        localizacao.visualizar();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Visualizando localização\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}

class GrupoTest {

    @Test
    void criar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "Novo Grupo\nNova Descrição\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Grupo
            Grupo grupo = new Grupo(1, "Grupo Antigo", new Usuario("Admin", "admin@example.com", "admin123", "Cidade"), "Descrição Antiga");
            grupo.criar();

            // Verificar se a instância foi criada corretamente
            assertEquals("Novo Grupo", grupo.getNome());
            assertEquals("Nova Descrição", grupo.getDescricao());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite o nome do grupo:\nDigite a descrição do grupo:\nGrupo criado!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void editar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "Novo Nome\nNova Descrição\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Grupo
            Grupo grupo = new Grupo(1, "Grupo Antigo", new Usuario("Admin", "admin@example.com", "admin123", "Cidade"), "Descrição Antiga");
            grupo.editar();

            // Verificar se a instância foi editada corretamente
            assertEquals("Novo Nome", grupo.getNome());
            assertEquals("Nova Descrição", grupo.getDescricao());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite o novo nome do grupo:\nDigite a nova descrição do grupo:\nGrupo editado!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void excluir() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Grupo
        Grupo grupo = new Grupo(1, "Grupo Antigo", new Usuario("Admin", "admin@example.com", "admin123", "Cidade"), "Descrição Antiga");
        grupo.excluir();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Grupo excluído!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void visualizar() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Grupo
        Grupo grupo = new Grupo(1, "Grupo Antigo", new Usuario("Admin", "admin@example.com", "admin123", "Cidade"), "Descrição Antiga");
        grupo.visualizar();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Visualizando detalhes do grupo\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void adicionarMembro() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Grupo
        Grupo grupo = new Grupo(1, "Grupo Antigo", new Usuario("Admin", "admin@example.com", "admin123", "Cidade"), "Descrição Antiga");
        grupo.adicionarMembro();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Membro adicionado ao grupo\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void removerMembro() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Grupo
        Grupo grupo = new Grupo(1, "Grupo Antigo", new Usuario("Admin", "admin@example


class ComentarioTest {

    @Test
    void criar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "Novo Comentário\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Comentario
            Usuario autor = new Usuario("Usuario", "usuario@example.com", "senha123", "Cidade");
            Comentario comentario = new Comentario(1, "Comentário Antigo", autor, "2023-01-01");
            comentario.criar();

            // Verificar se a instância foi criada corretamente
            assertEquals("Novo Comentário", comentario.getTexto());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite o texto do comentário:\nComentário adicionado!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void editar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "Novo Texto\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Comentario
            Usuario autor = new Usuario("Usuario", "usuario@example.com", "senha123", "Cidade");
            Comentario comentario = new Comentario(1, "Comentário Antigo", autor, "2023-01-01");
            comentario.editar();

            // Verificar se a instância foi editada corretamente
            assertEquals("Novo Texto", comentario.getTexto());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite o novo texto do comentário:\nComentário editado!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void excluir() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Comentario
        Usuario autor = new Usuario("Usuario", "usuario@example.com", "senha123", "Cidade");
        Comentario comentario = new Comentario(1, "Comentário Antigo", autor, "2023-01-01");
        comentario.excluir();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Comentário excluído!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void visualizar() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Comentario
        Usuario autor = new Usuario("Usuario", "usuario@example.com", "senha123", "Cidade");
        Comentario comentario = new Comentario(1, "Comentário Antigo", autor, "2023-01-01");
        comentario.visualizar();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Visualizando comentário\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}



class AtividadeTest {

    @Test
    void criar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "Nova Atividade\nNova Descrição\n2023-01-01\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Atividade
            Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
            Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
            atividade.criar();

            // Verificar se a instância foi criada corretamente
            assertEquals("Nova Atividade", atividade.getTitulo());
            assertEquals("Nova Descrição", atividade.getDescricao());
            assertEquals("2023-01-01", atividade.getDataHora());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite o título da atividade:\nDigite a descrição da atividade:\nDigite a data e hora da atividade:\nAtividade criada!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void editar() {
        // Salve os System.in e System.out originais
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;

        try {
            // Configurar a entrada simulada
            String input = "Novo Título\nNova Descrição\n2023-01-01\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            // Configurar a saída simulada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Criar uma nova instância de Atividade
            Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
            Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
            atividade.editar();

            // Verificar se a instância foi editada corretamente
            assertEquals("Novo Título", atividade.getTitulo());
            assertEquals("Nova Descrição", atividade.getDescricao());
            assertEquals("2023-01-01", atividade.getDataHora());

            // Verificar se a saída corresponde ao esperado
            String expectedOutput = "Digite o novo título da atividade:\nDigite a nova descrição da atividade:\nDigite a nova data e hora da atividade:\nAtividade editada!\n";
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restaurar System.in e System.out
            System.setIn(systemIn);
            System.setOut(systemOut);
        }
    }

    @Test
    void excluir() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.excluir();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Atividade excluída!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void visualizar() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.visualizar();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Visualizando detalhes da atividade\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void avaliarDetalhes() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.avaliarDetalhes();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Avaliando detalhes da atividade\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void adicionarLocal() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.adicionarLocal();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Local adicionado à atividade\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void receberNotificacao() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.receberNotificacao();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Recebendo notificação\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void adicionarAmigo() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.adicionarAmigo();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Amigo adicionado\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void pesquisarAtividade() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.pesquisarAtividade();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Pesquisando atividade\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void publicarAtividade() {
        // Configurar a saída simulada
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma nova instância de Atividade
        Localizacao localizacao = new Localizacao(10.0, 20.0, "Rua 123");
        Atividade atividade = new Atividade(1, "Atividade Antiga", "Descrição Antiga", "2022-01-01", localizacao);
        atividade.publicarAtividade();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Atividade publicada!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}

