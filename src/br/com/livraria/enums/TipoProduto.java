package br.com.livraria.enums;

import br.com.livraria.model.*;

public enum TipoProduto {
    LIVRO(Livro.class),
    JOGO(Jogo.class),
    FILME(Filme.class),
    ALBUM_MUSICA(AlbumMusica.class),
    BRINQUEDO(Brinquedo.class);

    public Class<? extends Produto> getTipoProduto() {
        return tipoProduto;
    }

    private Class<? extends Produto> tipoProduto;

    TipoProduto(Class <? extends Produto> tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
