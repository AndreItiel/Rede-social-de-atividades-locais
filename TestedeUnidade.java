import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    @Test
    void criar() {
        // Salvar os System.in e System.out originais
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

    // Outros métodos de teste...

    private static class Localizacao {
        private double latitude;
        private double longitude;
        private String endereco;

        public Localizacao(double latitude, double longitude, String endereco) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.endereco = endereco;
        }

        // Métodos getters
        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public String getEndereco() {
            return endereco;
        }
    }

    private static class Atividade {
        private int id;
        private String titulo;
        private String descricao;
        private String dataHora;
        private Localizacao localizacao;

        public Atividade(int id, String titulo, String descricao, String dataHora, Localizacao localizacao) {
            this.id = id;
            this.titulo = titulo;
            this.descricao = descricao;
            this.dataHora = dataHora;
            this.localizacao = localizacao;
        }

        // Métodos getters
        public String getTitulo() {
            return titulo;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDataHora() {
            return dataHora;
        }

        public void criar() {
            // Implementação do método criar
        }

        // Outros métodos da classe Atividade...
    }
}

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ComentarioTest {

    @Test
    void criar() {
        // Salvar os System.in e System.out originais
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
        // Salvar os System.in e System.out originais
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

    // Definição da classe Usuario
    private static class Usuario {
        private String nome;
        private String email;
        private String senha;
        private String cidade;

        public Usuario(String nome, String email, String senha, String cidade) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.cidade = cidade;
        }

        // Métodos getters
        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getSenha() {
            return senha;
        }

        public String getCidade() {
            return cidade;
        }
    }

    // Definição da classe Comentario
    private static class Comentario {
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

        // Métodos getters
        public String getTexto() {
            return texto;
        }

        public void criar() {
            // Implementação do método criar
        }

        public void editar() {
            // Implementação do método editar
        }

        public void excluir() {
            // Implementação do método excluir
        }

        public void visualizar() {
            // Implementação do método visualizar
        }
    }
}

import org.junit.jupiter.api.Test;


class GerenciavelTest {

    @Test
    void criar() {
        Gerenciavel gerenciavel = new ExemploGerenciavel(); // Substitua ExemploGerenciavel pela classe que implementa Gerenciavel


        gerenciavel.criar();

        // Inclua as asserções apropriadas para verificar se a operação de criar foi bem-sucedida
    }

    @Test
    void editar() {
        // Arrange
        Gerenciavel gerenciavel = new ExemploGerenciavel(); // Substitua ExemploGerenciavel pela classe que implementa Gerenciavel

        // Act
        gerenciavel.editar();

        // Assert
        // Inclua as asserções apropriadas para verificar se a operação de editar foi bem-sucedida
    }

    @Test
    void excluir() {
        Gerenciavel gerenciavel = new ExemploGerenciavel(); // Substitua ExemploGerenciavel pela classe que implementa Gerenciavel

        gerenciavel.excluir();

        // Assert
        // Inclua as asserções apropriadas para verificar se a operação de excluir foi bem-sucedida
    }

    @Test
    void visualizar() {
        Gerenciavel gerenciavel = new ExemploGerenciavel(); // Substitua ExemploGerenciavel pela classe que implementa Gerenciavel

        gerenciavel.visualizar();

        // Inclua as asserções apropriadas para verificar se a operação de visualizar foi bem-sucedida
    }

    private static class ExemploGerenciavel implements Gerenciavel {
        @Override
        public void criar() {
            // Implementação fictícia
        }

        @Override
        public void editar() {
            // Implementação fictícia
        }

        @Override
        public void excluir() {
            // Implementação fictícia
        }

        @Override
        public void visualizar() {
            // Implementação fictícia
        }
    }
}

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    @Test
    void criar() {
        // Salvar os System.in e System.out originais
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
            Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
            Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        // Salvar os System.in e System.out originais
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
            Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
            Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
        grupo.removerMembro();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Membro removido do grupo\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    // Definição da classe Usuario
    private static class Usuario {
        private String nome;
        private String email;
        private String senha;
        private String cidade;

        public Usuario(String nome, String email, String senha, String cidade) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.cidade = cidade;
        }
    }

    // Definição da classe Grupo
    private static class Grupo {
        private int id;
        private String nome;
        private Usuario admin;
        private String descricao;

        public Grupo(int id, String nome, Usuario admin, String descricao) {
            this.id = id;
            this.nome = nome;
            this.admin = admin;
            this.descricao = descricao;
        }

        // Métodos getters
        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void criar() {
            // Implementação do método criar
        }

        public void editar() {
            // Implementação do método editar
        }

        public void excluir() {
            // Implementação do método excluir
        }

        public void visualizar() {
            // Implementação do método visualizar
        }

        public void adicionarMembro() {
            // Implementação do método adicionarMembro
        }

        public void removerMembro() {
            // Implementação do método removerMembro
        }
    }
}

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    @Test
    void criar() {
        // Salvar os System.in e System.out originais
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
            Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
            Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        // Salvar os System.in e System.out originais
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
            Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
            Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
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
        Usuario admin = new Usuario("Admin", "admin@example.com", "admin123", "Cidade");
        Grupo grupo = new Grupo(1, "Grupo Antigo", admin, "Descrição Antiga");
        grupo.removerMembro();

        // Verificar se a saída corresponde ao esperado
        String expectedOutput = "Membro removido do grupo\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    // Definição da classe Usuario
    private static class Usuario {
        private String nome;
        private String email;
        private String senha;
        private String cidade;

        public Usuario(String nome, String email, String senha, String cidade) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.cidade = cidade;
        }
    }

    // Definição da classe Grupo
    private static class Grupo {
        private int id;
        private String nome;
        private Usuario admin;
        private String descricao;

        public Grupo(int id, String nome, Usuario admin, String descricao) {
            this.id = id;
            this.nome = nome;
            this.admin = admin;
            this.descricao = descricao;
        }

        // Métodos getters
        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void criar() {
            // Implementação do método criar
        }

        public void editar() {
            // Implementação do método editar
        }

        public void excluir() {
            // Implementação do método excluir
        }

        public void visualizar() {
            // Implementação do método visualizar
        }

        public void adicionarMembro() {
            // Implementação do método adicionarMembro
        }

        public void removerMembro() {
            // Implementação do método removerMembro
        }
    }
}

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
