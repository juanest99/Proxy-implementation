package Juego;

import java.io.Serializable;

public class Palabra implements Serializable {
    private String texto;

    public Palabra(String texto) {
        this.texto = texto.toUpperCase();
    }

    public String getTexto() {
        return texto;
    }
    @Override
    public String toString() {
        return texto;
    }
}
