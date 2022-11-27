package br.com.livraria.enums;

public enum GeneroLiterario implements Genero{
    ROMANCE("Romance"),
    TERROR("Terror"),
    AUTO_AJUDA("Auto ajuda"),
    CRONICA("Crônicas"),
    BIOGRAFIA("Biografico");

    private String descricao;

    GeneroLiterario(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
