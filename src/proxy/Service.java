package proxy;

import Jugadores.Persona;

public interface Service {
    void acceder(Persona persona, String contraseña, String rol);
}

