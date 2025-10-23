package Jugadores;

import java.io.*;
import java.util.ArrayList;

public class registroData {
    private static final String ARCHIVO = "usuarios.data";

    public static void guardarUsuario(Persona persona) {
        ArrayList<Persona>  personas = cargarUsuarios();
        personas.add(persona);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(personas);
            System.out.println("Usuario registrado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Persona> cargarUsuarios() {
        ArrayList<Persona> personas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            personas = (ArrayList<Persona>) ois.readObject();
        } catch (FileNotFoundException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personas;
    }
}
