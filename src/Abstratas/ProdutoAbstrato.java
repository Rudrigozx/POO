package Abstratas;

import Excecoes.LimiteAtingidoException;
import Excecoes.QuantidadeInsuficienteException;
import java.io.Serializable;

public abstract class  ProdutoAbstrato implements Serializable {
    public double preco;
    public String descricao ;
    public int quantidadeTotal;

    public ProdutoAbstrato(double preco, String descricao, int quantidade) {
        this.preco = preco;
        this.descricao = descricao;
        this.quantidadeTotal = quantidade;
    }
    public abstract double lucroBruto();

    public abstract void adicionarProduto(int adicionar) throws LimiteAtingidoException ;

    public void removerProduto(int remover) throws QuantidadeInsuficienteException {
        if (remover > this.quantidadeTotal){
            throw new QuantidadeInsuficienteException();
        }else {
            quantidadeTotal -= remover;
            System.out.println("\n============================\n");
        }
    }
    @Override
    public String toString() {
        return "-----------------------------------------" + "\n" +
                "\tdescricao: " + descricao + "\n" +
                "\tpreco: " + preco + "\n" +
                "\tquantidade Total: " + quantidadeTotal + "\n" +
                "-----------------------------------------";
    }
}
