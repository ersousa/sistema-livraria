package br.com.livraria.enums;

public enum GeneroFilmes implements Genero {
    TERROR("Terror"),
    ACAO("Ação"),
    COMEDIA("Comédia"),
    DOCUMENTARIO("Documentário"),
    SHOW("Show"),
    FICCAO_CIENTIFICA("Ficção cientifica"),
    ANIMACAO("Animação");

    private String descricao;

    GeneroFilmes(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
