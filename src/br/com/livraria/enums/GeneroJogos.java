package br.com.livraria.enums;

public enum GeneroJogos implements Genero {
    ACAO("Ação"),
    SHOOTER("Shooter"),
    LUTA("Luta"),
    RPG("RPG"),
    SOBREVIVENCIA("Sobrevivência");

    private String descricao;

    GeneroJogos(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
