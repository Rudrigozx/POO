package Basico;

import Abstratas.ProdutoAbstrato;
import Excecoes.LimiteAtingidoException;
import Interfaces.IEletronico;

import java.io.Serializable;

    public class Eletronico extends ProdutoAbstrato implements IEletronico, Serializable {
        public Especificacao especificacao;
        public double jurosParcelamento=0.05;
        public int limiteEstoque=500;


        public Eletronico(double preco, String descricao, int quantidade, Especificacao especificacao) {
            super(preco, descricao, quantidade);
            this.especificacao= especificacao;
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
        public  double lucroBruto(){
            double lucroB = this.preco * this.quantidadeTotal;
            double juros = lucroB * this.jurosParcelamento;
            lucroB+=juros;
            return lucroB;

        }
        @Override
        public String toString() {
            return "-----------------------------------------" + "\n" +
                    "\tdescricao: " + descricao + "\n" +
                    "\tpreco: " + preco + "\n" +
                    "\tquantidade Total: " + quantidadeTotal + "\n" +
                    "\tespecificacao: " + especificacao + "\n" +
                    "-----------------------------------------";
        }
    }

