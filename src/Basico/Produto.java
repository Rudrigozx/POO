package Basico;
import Abstratas.ProdutoAbstrato;
import Excecoes.LimiteAtingidoException;
import Interfaces.IProduto;


import java.io.Serializable;

public class Produto extends ProdutoAbstrato implements Serializable, IProduto {
    public int limiteEstoque;

    public Produto(double preco, String descricao, int quantidade, int limiteEstoque) {
        super(preco, descricao, quantidade);
        this.limiteEstoque = limiteEstoque;
    }

    @Override
    public void adicionarProduto(int adicionar) throws LimiteAtingidoException {
        if (adicionar + quantidadeTotal > limiteEstoque){
            throw new LimiteAtingidoException();
        }else {
            quantidadeTotal += adicionar;
            System.out.println("\nQuantidade Inserida!!!\n");
            System.out.println("\n============================\n");
        }
    }



    @Override
    public double lucroBruto() {
        double lucroB = this.preco * this.quantidadeTotal;
        return lucroB;
    }
    @Override
    public String toString() {
        return "-----------------------------------------" + "\n" +
                "\tdescricao: " + descricao + "\n" +
                "\tpreco: " + preco + "\n" +
                "\tquantidade Total: " + quantidadeTotal + "\n" +
                "\tLimite do Estoque: " + limiteEstoque + "\n" +
                "-----------------------------------------";
    }
}
