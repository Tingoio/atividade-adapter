public class Main {
    public static void main(String[] args) {
        GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial();

        Conteudo postTwitter = new Conteudo("Meu primeiro post via Adapter!", null);
        Credenciais credTwitter = new Credenciais();
        credTwitter.adicionarChave("userToken", "meu-token-twitter-123");

        ISocialMediaAdapter adapterTwitter = SocialMediaFactory.criarAdapter(TipoPlataforma.TWITTER);
        
        gerenciador.setPlataforma(adapterTwitter);
        
        RespostaPublicacao respTwitter = gerenciador.publicar(postTwitter, credTwitter);
        System.out.println("GERENCIADOR: Resposta recebida: " + respTwitter);

        
        Conteudo postInstagram = new Conteudo("Olha minha foto!", new byte[1024]);
        Credenciais credInstagram = new Credenciais();
        credInstagram.adicionarChave("apiKey", "minha-api-key-insta-abc");

        ISocialMediaAdapter adapterInstagram = SocialMediaFactory.criarAdapter(TipoPlataforma.INSTAGRAM);
        
        gerenciador.setPlataforma(adapterInstagram);
        
        RespostaPublicacao respInstagram = gerenciador.publicar(postInstagram, credInstagram);
        System.out.println("GERENCIADOR: Resposta recebida: " + respInstagram);


        System.out.println("\n--- GERENCIADOR: Testando erro (Twitter com mídia) ---");
        Conteudo postTwitterComErro = new Conteudo("Post com mídia", new byte[100]);
        gerenciador.setPlataforma(adapterTwitter);
        RespostaPublicacao respErro = gerenciador.publicar(postTwitterComErro, credTwitter);
        System.out.println("GERENCIADOR: Resposta recebida: " + respErro);
    }
}