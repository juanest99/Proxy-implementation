package Juego;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPalabras {
    private static final String ARCHIVO = "palabras.data";

    public static void agregarPalabra(Palabra palabra) {
        List<Palabra> palabras = cargarPalabras();
        palabras.add(palabra);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(palabras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Palabra> cargarPalabras() {
        List<Palabra> palabras = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            palabras = (List<Palabra>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Archivo aún no existe → lista vacía
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return palabras;
    }

    public static Palabra palabraAleatoria() {
        List<Palabra> palabras = cargarPalabras();
        if (palabras.isEmpty()) return null;
        int index = (int) (Math.random() * palabras.size());
        return palabras.get(index);
    }
}
