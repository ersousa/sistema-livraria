package br.com.livraria.model;

import br.com.livraria.Estoque;

import java.util.HashMap;

public class CatalogoProdutos {

    private static Estoque estoque;

    private static Integer id = 0;

    private static HashMap<Integer, Produto> listaProdutos = new HashMap<>();

    public CatalogoProdutos() {
        estoque = new Estoque();
    }

    public Produto getProduto(Integer idProduto){
        return listaProdutos.get(idProduto);
    }

    public String addProduto(Produto produto, Integer qtdInicialEmEstoque) {
        produto.setId(getId());
        if(listaProdutos.containsKey(produto.getId())){
            return "Já existe um cadastro de produto com esse ID!";
        } else {
            listaProdutos.put(produto.getId(), produto);
            estoque.atualizar(produto, qtdInicialEmEstoque);
            return "Produto: " + produto.toString() + " cadastrado com sucesso!";
        }
    }

    public String updateProduto(Produto produtoModificado, Integer id) {
        Produto produtoAtual = listaProdutos.get(id);
        if(produtoAtual != null){
            Class<? extends Produto> tipoProduto = produtoAtual.getClass();
            if(tipoProduto.isInstance(produtoModificado)){
                listaProdutos.put(id, produtoModificado);
            } else {
                return "O produto que está tentando modificar não é compatível com o produto cadastrado!";
            }
        } else {
            return "Não foi encontrado nenhum produto para o código de ID informado.";
        }
        return "Produto: " + produtoModificado.toString() + " atualizado com sucesso!";
    }

    public String deleteProduto(Integer id){
        if(listaProdutos.containsKey(id)){
            listaProdutos.remove(id);
            estoque.removerItem(id);
            return "Produto id: " + id + " removido com sucesso!";
        } else {
            return "Id do produto inválido.";
        }
    }

    private Integer getId(){
        return this.id += 1;
    }

}
