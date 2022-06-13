package Interfaces;

import Excecoes.LimiteAtingidoException;

public interface IEletronico {

    public void adicionarProduto(int adicionar) throws LimiteAtingidoException;
    public double lucroBruto();

}