package br.com.livraria.model;

import br.com.livraria.enums.TipoBrinquedo;

public class Brinquedo extends Produto{
    private TipoBrinquedo tipo;

    public Brinquedo(TipoBrinquedo tipo, String nome, Double preco) {
        this.tipo = tipo;
        this.setNome(nome);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Brinquedo -> " +"id="+super.getId()+", nome='"+super.getNome()+'\'';
    }
}
