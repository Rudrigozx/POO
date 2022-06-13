package Basico;

import Interfaces.IEletronico;
import java.io.Serializable;

public class Smartphone extends  Eletronico  implements IEletronico, Serializable {

    public Smartphone(double preco, String descricao, int quantidade, Especificacao especificacao) {
        super(preco, descricao, quantidade,especificacao);
    }
}
