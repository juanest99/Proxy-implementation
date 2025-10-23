package Jugadores;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private String contraseñaJugar;
    private String contraseñaCrear;

    public Persona(String nombre, String contraseñaJugar, String contraseñaCrear) {
        this.nombre = nombre;
        this.contraseñaJugar = contraseñaJugar;
        this.contraseñaCrear= contraseñaCrear;

    }

    public String getNombre() {
        return nombre;
    }
    public String getContraseñaJugar(){
        return contraseñaJugar;
    }
    public String getContraseñaCrear(){
        return contraseñaCrear;
    }
    public String toString() {
        return "Usuario: " + nombre + " (Admin: " + contraseñaCrear + ")";
    }
}
