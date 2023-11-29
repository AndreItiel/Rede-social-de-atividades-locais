class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String localizacao;

    public Usuario(String nome, String email, String senha, String localizacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
