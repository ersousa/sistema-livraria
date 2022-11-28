package br.com.livraria;

import br.com.livraria.enums.TipoProduto;
import br.com.livraria.model.Produto;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    class EntidadeEstoqueProduto {
        TipoProduto tipoProduto;
        Integer idProduto;
        String descricao;
        Integer quantidade;

        public EntidadeEstoqueProduto(Produto produto, Integer quantidade) {
            this.tipoProduto = getTipoProduto(produto);
            this.idProduto = produto.getId();
            this.descricao = produto.getNome();
            this.quantidade = quantidade;
        }

        private TipoProduto getTipoProduto(Produto produto) {
            for (TipoProduto tipo : TipoProduto.values()) {
                if (tipo.getTipoProduto().isInstance(produto)) {
                    return tipo;
                }
            }
            return null;
        }
    }

    private static HashMap<Integer, EntidadeEstoqueProduto> estoqueProdutos = new HashMap<>();;

    public static Integer getQtdTipoProdutoEmEstoque(TipoProduto tipoProduto) {
        Integer quantidade = 0;
        for (Map.Entry<Integer, EntidadeEstoqueProduto> entry : estoqueProdutos.entrySet()) {
            EntidadeEstoqueProduto estoqueProduto = entry.getValue();
            if (estoqueProduto.tipoProduto.equals(tipoProduto)) {
                quantidade += estoqueProduto.quantidade;
            }
        }
        return quantidade;
    }

    public static Integer getQuantidadeItemEmEstoque(Integer idProduto) {
        EntidadeEstoqueProduto entidadeEstoqueProduto = estoqueProdutos.get(idProduto);
        if (entidadeEstoqueProduto != null) {
            return estoqueProdutos.get(idProduto).quantidade;
        }else {
            return -1;
        }
    }

    public static Integer getEstoqueTotal() {
        Integer estoqueTotal = 0;
        for (Map.Entry<Integer, EntidadeEstoqueProduto> entry : estoqueProdutos.entrySet()) {
            EntidadeEstoqueProduto estoqueProduto = entry.getValue();
            estoqueTotal += estoqueProduto.quantidade;
        }
        return estoqueTotal;
    }

    public void atualizar(Produto produto, Integer qtdInicialEmEstoque) {
        EntidadeEstoqueProduto produtoAtual = estoqueProdutos.get(produto.getId());
        //Se já possuir o produto no estoque incrementa a quantidade
        if (produtoAtual != null) {
            produtoAtual.quantidade += qtdInicialEmEstoque;
            //Se não, inclui o novo produto no estoque com a quantidade inicial recebida
        }else {
            produtoAtual = new EntidadeEstoqueProduto(produto, qtdInicialEmEstoque);
            estoqueProdutos.put(produto.getId(), produtoAtual);
        }
    }

    public static void removerItem(Integer idItem){
        if(estoqueProdutos.containsKey(idItem)){
            estoqueProdutos.remove(idItem);
        }
    }

    public static void darBaixa(Integer id, Integer quantidade) {
        EntidadeEstoqueProduto itemEstoque = estoqueProdutos.get(id);
        if(itemEstoque != null){
            itemEstoque.quantidade -= quantidade;
        }
        estoqueProdutos.put(id, itemEstoque);
    }
}
