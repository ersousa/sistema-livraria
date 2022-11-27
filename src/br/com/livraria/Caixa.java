package br.com.livraria;

public class Caixa {
    private static Double totalAtualizado = 0D;

    public void receber(Double valor){
        this.totalAtualizado += valor;
    }

    public Double consultarTotal(){
        return this.totalAtualizado;
    }
}
