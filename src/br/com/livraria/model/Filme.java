package br.com.livraria.model;

import br.com.livraria.enums.Genero;

public class Filme extends Produto{
    private String estudio;
    private String diretores;
    private Genero genero;
    private String produtores;

    public Filme(String estudio, String diretores, Genero genero, String produtores, String nome, Double preco) {
        this.estudio = estudio;
        this.diretores = diretores;
        this.genero = genero;
        this.produtores = produtores;
        this.setNome(nome);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Filme -> " +"id="+super.getId()+", nome='"+super.getNome()+'\'';
    }
}
