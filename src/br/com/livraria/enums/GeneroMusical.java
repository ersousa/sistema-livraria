package br.com.livraria.enums;

public enum GeneroMusical implements Genero{
    ERUDITO("Erudito"),
    ROCK("Rock"),
    MPB("Música Popular Brasileira"),
    BOSSA_NOVA("Bossa Nova"),
    JAZZ("Jazz"),
    BLUES("Blues");

    private String descricao;

    GeneroMusical(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
