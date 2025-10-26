# Atividade — Padrão Adapter (Integração com Mídias Sociais)

## Visão geral
- Projeto didático em Java demonstrando o padrão Adapter para publicar conteúdo em diferentes plataformas (Twitter/Instagram) por meio de uma interface comum.
- O cliente (aplicação) interage apenas com `ISocialMediaAdapter` via `GerenciadorMidiaSocial`, sem conhecer detalhes de cada API.

## O que foi implementado
- Interface única: `ISocialMediaAdapter` com o método `postar(Conteudo, Credenciais)`.
- Adapters concretos: `TwitterAdapter` e `InstagramAdapter` encapsulam `TwitterAPI` e `InstagramAPI` (APIs simuladas).
- Orquestração: `GerenciadorMidiaSocial` recebe o adapter ativo e centraliza a publicação.
- Fábrica: `SocialMediaFactory` cria o adapter com base no `TipoPlataforma`.
- Modelos: `Conteudo` (texto/mídia), `Credenciais` (chave-valor), `RespostaPublicacao` (sucesso/id/erro).
- Execução: `Main` demonstra o fluxo publicando no Twitter (texto) e Instagram (mídia), incluindo caso de erro.

## Exemplo de uso (resumo)
```java
GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial();
ISocialMediaAdapter twitter = SocialMediaFactory.criarAdapter(TipoPlataforma.TWITTER);
ISocialMediaAdapter instagram = SocialMediaFactory.criarAdapter(TipoPlataforma.INSTAGRAM);

Conteudo c1 = new Conteudo("Meu primeiro post via Adapter!", null);
Credenciais ct = new Credenciais();
ct.adicionarChave("userToken", "meu-token-twitter-123");

gerenciador.setPlataforma(twitter);
RespostaPublicacao r1 = gerenciador.publicar(c1, ct);

Conteudo c2 = new Conteudo("Olha minha foto!", new byte[1024]);
Credenciais ci = new Credenciais();
ci.adicionarChave("apiKey", "minha-api-key-insta-abc");

gerenciador.setPlataforma(instagram);
RespostaPublicacao r2 = gerenciador.publicar(c2, ci);
```