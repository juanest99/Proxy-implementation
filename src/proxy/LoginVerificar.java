package proxy;

import Jugadores.*;

import java.util.ArrayList;

public class LoginVerificar implements Login {
    @Override
    public Persona login(String nombre, String contraseña) {
        ArrayList<Persona> personas = registroData.cargarUsuarios();
        for (Persona persona : personas) {
            if(persona.getNombre().equals(nombre) && (persona.getContraseñaJugar().equals(contraseña)
            || persona.getContraseñaCrear().equals(contraseña))){
                return persona;
            }
        }
        return null;
    }
}
