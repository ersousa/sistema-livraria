package br.com.livraria.model;

import br.com.livraria.enums.Genero;
import br.com.livraria.enums.GeneroMusical;

public class AlbumMusica extends Produto {
    private String artista;
    private Genero genero;
    private String selo;

    public AlbumMusica(String artista, GeneroMusical genero, String selo, String nome, Double preco) {
        this.artista = artista;
        this.genero = genero;
        this.selo = selo;
        this.setNome(nome);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Álbum de música -> " +"id="+super.getId()+", nome='"+super.getNome()+'\'';
    }
}
