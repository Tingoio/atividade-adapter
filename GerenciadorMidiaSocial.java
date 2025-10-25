class GerenciadorMidiaSocial {
    private ISocialMediaAdapter adapterAtual;

    public void setPlataforma(ISocialMediaAdapter adapter) {
        this.adapterAtual = adapter;
    }

    public RespostaPublicacao publicar(Conteudo conteudo, Credenciais credenciais) {
        if (adapterAtual == null) {
            throw new IllegalStateException("Nenhuma plataforma (Adapter) foi selecionada.");
        }
        
        System.out.println("\n--- GERENCIADOR: Tentando postar na plataforma: " + adapterAtual.getClass().getSimpleName() + " ---");
        return adapterAtual.postar(conteudo, credenciais);
    }
}