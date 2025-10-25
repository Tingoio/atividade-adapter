class SocialMediaFactory {
    public static ISocialMediaAdapter criarAdapter(TipoPlataforma tipo) {
        switch (tipo) {
            case TWITTER:
                return new TwitterAdapter();
            case INSTAGRAM:
                return new InstagramAdapter();
            default:
                throw new IllegalArgumentException("Plataforma não suportada: " + tipo);
        }
    }
}