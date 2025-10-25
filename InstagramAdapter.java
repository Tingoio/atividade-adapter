class InstagramAdapter implements ISocialMediaAdapter {
    private final InstagramAPI instagramApi;

    public InstagramAdapter() {
        this.instagramApi = new InstagramAPI();
    }

    @Override
    public RespostaPublicacao postar(Conteudo conteudo, Credenciais credenciais) {
        String apiKey = credenciais.getChave("apiKey");
        
        if (apiKey == null) {
            return new RespostaPublicacao(false, null, "apiKey não fornecida para o Instagram.");
        }
        if (conteudo.getMidia() == null) {
            return new RespostaPublicacao(false, null, "Instagram requer mídia (imagem/vídeo).");
        }
        
        try {
            String id = instagramApi.shareStory(apiKey, conteudo.getMidia(), conteudo.getTexto());
            return new RespostaPublicacao(true, id, null);
        } catch (Exception e) {
            return new RespostaPublicacao(false, null, "Erro na API do Instagram: " + e.getMessage());
        }
    }
}