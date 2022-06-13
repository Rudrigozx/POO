package Excecoes;

public class QuantidadeInsuficienteException extends Exception{
    public QuantidadeInsuficienteException() {
        super("Erro!!! Quantidade insuficiente\n============================\n");
    }
}
