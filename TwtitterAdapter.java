class TwitterAdapter implements ISocialMediaAdapter {
    private final TwitterAPI twitterApi;

    public TwitterAdapter() {
        this.twitterApi = new TwitterAPI();
    }

    @Override
    public RespostaPublicacao postar(Conteudo conteudo, Credenciais credenciais) {
        String token = credenciais.getChave("userToken");
        
        if (token == null) {
            return new RespostaPublicacao(false, null, "userToken não fornecido para o Twitter.");
        }
        if (conteudo.getMidia() != null) {
            return new RespostaPublicacao(false, null, "TwitterAdapter (MVP) só suporta texto.");
        }
        
        try {
            twitterApi.postTweet(token, conteudo.getTexto());
            return new RespostaPublicacao(true, "tweet_" + System.currentTimeMillis(), null);
        } catch (Exception e) {
            return new RespostaPublicacao(false, null, "Erro na API do Twitter: " + e.getMessage());
        }
    }
}