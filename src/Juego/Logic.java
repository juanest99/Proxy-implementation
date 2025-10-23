package Juego;

import javax.swing.*;
import java.util.List;

public class Logic{
    public void jugar() {
        List<Palabra> palabras = GestorPalabras.cargarPalabras();
        if (palabras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Parece que no tenemos palabras disponibles, solicita a un admin");
            return;
        }

        StringBuilder opciones = new StringBuilder("Selecciona una palabra para jugar:\n");
        for (int i = 0; i < palabras.size(); i++) {
            opciones.append((i + 1)).append(". Palabra ").append(i + 1).append("\n");
        }

        String seleccionStr = JOptionPane.showInputDialog(null, opciones.toString());
        if (seleccionStr == null) return;

        int seleccion;
        try {
            seleccion = Integer.parseInt(seleccionStr) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Parece que ocurrio un error");
            return;
        }

        if (seleccion < 0 || seleccion >= palabras.size()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste un valor no definido");
            return;
        }

        Palabra palabraSecreta = palabras.get(seleccion);
        String secreta = palabraSecreta.getTexto().toUpperCase();

        int intentos = 6;
        boolean adivinada = false;

        JOptionPane.showMessageDialog(null, "Adivina la palabra de " + secreta.length() + " letras.");

        while (intentos > 0 && !adivinada) {
            String intento = JOptionPane.showInputDialog(null,
                    "Intentos restantes: " + intentos + "\nIngresa una palabra de " + secreta.length() + " letras:");

            if (intento == null) return;
            intento = intento.trim().toUpperCase();

            if (intento.length() != secreta.length()) {
                JOptionPane.showMessageDialog(null, "Debe tener " + secreta.length() + " letras.");
                continue;
            }

            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < secreta.length(); i++) {
                char c = intento.charAt(i);
                if (c == secreta.charAt(i)) {
                    resultado.append(" ✓ ");
                } else if (secreta.contains(String.valueOf(c))) {
                    resultado.append(" o ");
                } else {
                    resultado.append(" x ");
                }
            }

            JOptionPane.showMessageDialog(null, intento + "\n" + resultado);

            if (intento.equals(secreta)) {
                adivinada = true;
                JOptionPane.showMessageDialog(null, "Lo lograste");
            } else {
                intentos--;
            }
        }

        if (!adivinada) {
            JOptionPane.showMessageDialog(null, "Buen intento, la palabra era " + secreta);
        }
    }
}
