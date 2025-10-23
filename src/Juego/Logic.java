package Juego;

import javax.swing.*;

public class Logic{
    private Palabra palabraSecreta;

    public Logic() {
        this.palabraSecreta = GestorPalabras.palabraAleatoria();
    }

    public void jugar() {
        if (palabraSecreta == null) {
            JOptionPane.showMessageDialog(null, "No hay palabras disponibles. Contacta al admin.");
            return;
        }

        String secreta = palabraSecreta.getTexto();
        int intentos = 6;
        boolean adivinada = false;

        JOptionPane.showMessageDialog(null, "¡Bienvenido a Wordle! Adivina la palabra de 5 letras.");

        while (intentos > 0 && !adivinada) {
            String intento = JOptionPane.showInputDialog(null,
                    "Tienes " + intentos + " intentos.\nIngresa una palabra de 5 letras:");

            if (intento == null) return; // usuario canceló
            intento = intento.trim().toUpperCase();

            if (intento.length() != secreta.length()) {
                JOptionPane.showMessageDialog(null, "Debe tener " + secreta.length() + " letras.");
                continue;
            }

            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < secreta.length(); i++) {
                char c = intento.charAt(i);
                if (c == secreta.charAt(i)) {
                    resultado.append("🟩"); // letra correcta en lugar correcto
                } else if (secreta.contains(String.valueOf(c))) {
                    resultado.append("🟨"); // letra correcta en lugar incorrecto
                } else {
                    resultado.append("⬜"); // letra no está
                }
            }

            JOptionPane.showMessageDialog(null, intento + "\n" + resultado);

            if (intento.equals(secreta)) {
                adivinada = true;
                JOptionPane.showMessageDialog(null, "🎉 ¡Adivinaste la palabra!");
            } else {
                intentos--;
            }
        }

        if (!adivinada) {
            JOptionPane.showMessageDialog(null, "💀 Se acabaron los intentos. La palabra era: " + secreta);
        }
    }
}
