package br.com.livraria.model;

public class Produto {
    private Integer id;
    private String nome;
    private Double preco;
    private Boolean isPublicoAdulto;


    public Boolean getPublicoAdulto() {
        return isPublicoAdulto;
    }

    public void setPublicoAdulto(Boolean publicoAdulto) {
        isPublicoAdulto = publicoAdulto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this. id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
