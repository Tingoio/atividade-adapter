class RespostaPublicacao {
    private boolean sucesso;
    private String idPublicacao;
    private String mensagemErro;

    public RespostaPublicacao(boolean sucesso, String idPublicacao, String mensagemErro) {
        this.sucesso = sucesso;
        this.idPublicacao = idPublicacao;
        this.mensagemErro = mensagemErro;
    }

    // Getters
    public boolean isSucesso() { return sucesso; }
    public String getIdPublicacao() { return idPublicacao; }
    public String getMensagemErro() { return mensagemErro; }

    @Override
    public String toString() {
        return "RespostaPublicacao [sucesso=" + sucesso + ", id=" + idPublicacao + ", erro=" + mensagemErro + "]";
    }
}