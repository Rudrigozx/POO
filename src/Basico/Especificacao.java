package Basico;

import java.io.Serializable;

public class Especificacao implements Serializable {
    String armazenamento;
    String ram;
    String bateria;

    public Especificacao(String armazenamento, String ram, String bateria) {
        this.armazenamento=armazenamento;
        this.bateria= bateria;
        this.ram=ram;
    }
    @Override
    public String toString() {
        return
                "\n\t\tarmazenamento= " + armazenamento + "\n" +
                "\t\tram= " + ram + "\n" +
                "\t\tbateria= " + bateria + "\n" +
                "-----------------------------------------";
    }
}
