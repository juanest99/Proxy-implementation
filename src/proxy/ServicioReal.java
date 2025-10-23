package proxy;
import Juego.*;
import Jugadores.Persona;

import javax.swing.*;

public class ServicioReal implements Service {

    public void acceder(Persona persona, String contraseña, String rol) {
        if (rol.trim().equals("Admin")) {
            JOptionPane.showMessageDialog(null, "Usuario accede contrasena admin");
            menuAdmin();
        }
        else if (rol.trim().equals("Normalito")) {
            JOptionPane.showMessageDialog(null, "Usuario accede contrasena Normalito");
            menuJugador();
        }


    }

    private void menuAdmin() {
        int opt;
        do {
            String menu = """
                    MENU ADMINISTRADOR
                    1. Agregar palabra
                    2. Ver palabras
                    3. Salir
                    """;
            String input = JOptionPane.showInputDialog(null, menu);
            if (input == null) break;
            opt = Integer.parseInt(input);

            switch (opt) {
                case 1:
                    String texto = JOptionPane.showInputDialog(null, "Ingrese nueva palabra (5 letras):");
                    if (texto != null && texto.length() == 5) {
                        GestorPalabras.agregarPalabra(new Palabra(texto));
                        JOptionPane.showMessageDialog(null, "Palabra agregada correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "La palabra no corresponde a lo pedido");
                    }
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Palabras disponibles: " + GestorPalabras.cargarPalabras());
                break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Cerrando sesion admin");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "NO");
                    break;
            }
        } while (opt != 3);
    }

    private void menuJugador() {
        int opt;
        do {
            String menu = """
                    MENU JUGADOR
                    1. Jugar Wordle
                    2. Salir
                    """;
            String input = JOptionPane.showInputDialog(null, menu);
            if (input == null) break;
            opt = Integer.parseInt(input);

            switch (opt) {
                case 1:
                    new Logic().jugar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Cerrando sesion jugador");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "NO");
                    break;
            }
        } while (opt != 2);
    }
}
