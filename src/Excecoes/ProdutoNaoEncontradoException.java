package Excecoes;
import Basico.Produto;

public class ProdutoNaoEncontradoException extends Exception{

    public ProdutoNaoEncontradoException() {
        super("Produto nao encontrado!!!");

    }
}

