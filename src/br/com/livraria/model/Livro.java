package br.com.livraria.model;

import br.com.livraria.enums.Genero;
import br.com.livraria.enums.GeneroJogos;
import br.com.livraria.enums.GeneroLiterario;

public class Livro extends Produto{
    private Genero genero;
    private String escritor;
    private String editora;

    public Livro(GeneroLiterario genero, String escritor, String editora, String nome, Double preco) {
        this.genero = genero;
        this.escritor = escritor;
        this.editora = editora;
        this.setNome(nome);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Livro -> " +"id="+super.getId()+", nome='"+super.getNome()+'\'';
    }
}
