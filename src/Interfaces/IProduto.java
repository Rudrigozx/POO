package Interfaces;

import Excecoes.LimiteAtingidoException;

public interface IProduto {

    public void adicionarProduto(int adicionar) throws LimiteAtingidoException;
    public double lucroBruto();

}