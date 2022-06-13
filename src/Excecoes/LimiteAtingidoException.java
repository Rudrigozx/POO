package Excecoes;

public class LimiteAtingidoException extends Exception{
    public LimiteAtingidoException() {
        super("Erro!!! Limite atingido\n============================\n");
    }
}
