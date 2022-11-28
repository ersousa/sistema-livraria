package br.com.livraria;

public class Caixa {
    private static Double totalAtualizado = 0D;

    public void receber(Double valor) {
        this.totalAtualizado += valor;
    }

    public void receberComDesconto(Double valor) {
        valor *= 0.85;
        this.totalAtualizado += valor;
    }

    public String registrarCompra(Double preco, Integer quantidade) {
        Double totalCompra = preco * quantidade;
        if (possuiDesconto(totalCompra)) {
            receberComDesconto(totalCompra);
            return "Compra efetuada com sucesso!! Você recebeu um desconto de 15%!!!!!!";
        }else {
            receber(totalCompra);
            return "Compra efetuada com sucesso!!";
        }
    }

    public boolean possuiDesconto(Double total) {
        return total > 200.0;
    }

    public Double consultarTotal() {
        return this.totalAtualizado;
    }
}
