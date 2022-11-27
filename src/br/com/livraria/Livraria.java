package br.com.livraria;

import br.com.livraria.enums.*;
import br.com.livraria.model.*;

public class Livraria {

    private CatalogoProdutos catalogo;
    private Caixa caixa;

    public Livraria(CatalogoProdutos catalogo, Caixa caixa) {
        this.catalogo = catalogo;
        this.caixa = caixa;
    }

    private String cadastrarProduto(Produto produto, Integer qtdInicialEmEstoque, boolean isPublicoAdulto) {
        produto.setPublicoAdulto(isPublicoAdulto);
        return this.catalogo.addProduto(produto, qtdInicialEmEstoque);
    }

    private Integer getEstoqueTotal(){
        return Estoque.getEstoqueTotal();
    }

    private String consultarProduto(Integer idProduto) {
        Produto produto = this.catalogo.getProduto(idProduto);
        if(produto != null){
            return produto.toString() + ", " + "Preço: R$ " + produto.getPreco();
        } else {
            return "Produto não encontrado!";
        }
    }

    private String alterarProduto(Integer id, Produto produtoModificado) {
        return this.catalogo.updateProduto(produtoModificado, id);
    }

    private String excluirProduto(Integer id) {
        return this.catalogo.deleteProduto(id);
    }

    private Integer getQuantidadeTipoProdutoEmEstoque(TipoProduto tipoProduto){
        return Estoque.getQtdTipoProdutoEmEstoque(tipoProduto);
    }

    private String realizarCompra(Produto produto, Integer quantidade) {
        if(verificarClassificacaoProduto(produto)){
            return "Produto destinado ao Público adulto, necessário apresentar documentos.";
        }
        if (Estoque.getQuantidadeItemEmEstoque(produto.getId()) >= quantidade) {
            Estoque.darBaixa(produto.getId(), quantidade);
            String compraRealizada = registrarCompraCaixa(produto.getPreco(), quantidade);
            return compraRealizada;
        }
        return "Quantidade solicitada indisponível!";
    }

    private boolean verificarClassificacaoProduto(Produto produto) {
        return produto.getPublicoAdulto();
    }

    private String registrarCompraCaixa(Double preco, Integer quantidade) {
        Double totalCompra = preco * quantidade;
        if(totalCompra > 200.0){
            totalCompra *= 0.85;
            this.caixa.receber(totalCompra);
            return "Compra efetuada com sucesso!! Você recebeu um desconto de 15%!!!!!!";
        } else {
            this.caixa.receber(totalCompra);
            return "Compra efetuada com sucesso!!";
        }
    }

    public Caixa getCaixa() {
        return this.caixa;
    }

    public CatalogoProdutos getCatalogo() {
        return this.catalogo;
    }

    public static void main(String[] args)  {
        Livraria livraria = new Livraria(new CatalogoProdutos(), new Caixa());

        AlbumMusica cdMusica = new AlbumMusica(
                "David Bowie",
                GeneroMusical.ROCK,
                "Java Records",
                "Ziggy",
                15D);

        System.out.println(livraria.cadastrarProduto(cdMusica, 13, true));
        System.out.println("Quantidade em estoque do produto: "+cdMusica.toString()+" = "+Estoque.getQuantidadeItemEmEstoque(cdMusica.getId()));
        System.out.print("\n");

        Livro livro = new Livro(
                GeneroLiterario.TERROR,
                "Mary Shelley",
                "Horror Books",
                "Frankenstein",
                7.9
        );

        System.out.println(livraria.cadastrarProduto(livro, 5, true));
        System.out.println("Quantidade em estoque do produto: "+livro.toString()+" = "+Estoque.getQuantidadeItemEmEstoque(livro.getId()));
        System.out.print("\n");

        Jogo jogo = new Jogo(
                "Nintendo",
                GeneroJogos.ACAO,
                "Nintendo",
                "Super Mario Bros",
                29.9
        );

        System.out.println(livraria.cadastrarProduto(jogo, 250, false));
        System.out.println("Quantidade em estoque do produto: "+jogo.toString()+" = "+ Estoque.getQuantidadeItemEmEstoque(jogo.getId()));
        System.out.print("\n");

        Filme filme = new Filme(
                "Universal",
                "Steven Spielberg",
                GeneroFilmes.FICCAO_CIENTIFICA,
                "Jhon",
                "Jurassic Park",
                50.5
        );

        System.out.println(livraria.cadastrarProduto(filme, 12, false));
        System.out.println("Quantidade em estoque do produto: "+filme.toString()+" = "+ Estoque.getQuantidadeItemEmEstoque(filme.getId()));
        System.out.print("\n");

        Filme filme2 = new Filme(
                "Pixar",
                "JJ",
                GeneroFilmes.ANIMACAO,
                "Jhon",
                "Soul",
                15.0
        );

        System.out.println(livraria.cadastrarProduto(filme2, 8, false));
        System.out.println("Quantidade em estoque do produto: "+filme2.toString()+" = "+ Estoque.getQuantidadeItemEmEstoque(filme2.getId()));
        System.out.print("\n");

        Brinquedo brinquedo = new Brinquedo(
                TipoBrinquedo.JOGO_TABULEIRO,
                "War",
                100.0

        );

        System.out.println(livraria.cadastrarProduto(brinquedo, 33, true));
        System.out.println("Quantidade em estoque do produto: "+brinquedo.toString()+" = "+ Estoque.getQuantidadeItemEmEstoque(brinquedo.getId()));
        System.out.print("\n");

        System.out.println("Total de produtos em estoque: " + livraria.getEstoqueTotal());
        System.out.print("\n");

        System.out.println("Consultando produto com id = 4");
        System.out.println(livraria.consultarProduto(4));
        System.out.print("\n");

        System.out.println("Consultando produto com id = 99");
        System.out.println(livraria.consultarProduto(99));
        System.out.print("\n");

        System.out.println("tentando alterar um album de musica passando um brinquedo.");
        System.out.println(livraria.alterarProduto(1, brinquedo));
        System.out.print("\n");

        //Alterando o preço do item id: 1
        System.out.println("antes de alterar " + livraria.consultarProduto(1));
        cdMusica.setPreco(19.99);
        System.out.println("depois de alterar " + livraria.alterarProduto(1, cdMusica) + " novo preço-> " + cdMusica.getPreco());
        System.out.print("\n");

        System.out.println("deletando produto id 99");
        System.out.println(livraria.excluirProduto(99));
        System.out.print("\n");

        System.out.println("deletando produto id 5");
        System.out.println(livraria.excluirProduto(5));
        System.out.print("\n");

        System.out.println("Quantidade de Filmes: " + livraria.getQuantidadeTipoProdutoEmEstoque(TipoProduto.FILME));

        System.out.println("Total de produtos em estoque: " + livraria.getEstoqueTotal());
        System.out.print("\n");

        System.out.println("Total atual no caixa: " + livraria.getCaixa().consultarTotal());
        System.out.println("Estoque atual do item: " + livraria.getCatalogo().getProduto(filme.getId()).toString() + " = " + Estoque.getQuantidadeItemEmEstoque(filme.getId()));
        System.out.println("Realizando compra ..." );
        System.out.println(livraria.realizarCompra(filme, 2));
        System.out.println("Total atual no caixa após registrar compra: " + livraria.getCaixa().consultarTotal());
        System.out.println("Estoque do item após comprar: " + Estoque.getQuantidadeItemEmEstoque(filme.getId()));
        System.out.print("\n");

        System.out.println("Comprando um produto destinado a adultos...");
        System.out.println(livraria.realizarCompra(livro, 2));
        System.out.print("\n");

        System.out.println("Realizando uma compra de mais de R$ 200,00");
        System.out.println(livraria.realizarCompra(filme, 4));
        System.out.println("Total atual no caixa após registrar compra: " + livraria.getCaixa().consultarTotal());
        System.out.println("Estoque do item após comprar: " + Estoque.getQuantidadeItemEmEstoque(filme.getId()));

    }
}
