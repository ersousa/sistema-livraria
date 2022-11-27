package br.com.livraria.model;

import br.com.livraria.enums.Genero;
import br.com.livraria.enums.GeneroJogos;

public class Jogo extends Produto{
    private String distribuidora;
    private Genero genero;
    private String estudio;

    public Jogo(String distribuidora, GeneroJogos genero, String estudio, String nome, Double preco) {
        this.distribuidora = distribuidora;
        this.genero = genero;
        this.estudio = estudio;
        this.setNome(nome);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Jogo -> " +"id="+super.getId()+", nome='"+super.getNome()+'\'';
    }
}
