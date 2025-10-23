package proxy;

import Jugadores.Persona;

public class ProxyServicio implements Service {
    private ServicioReal servicioReal;

    public ProxyServicio() {
        this.servicioReal = new ServicioReal();

    }
    @Override
    public void acceder(Persona persona, String contraseña, String rol) {

        if (persona== null){
            System.out.printf("No existe el usuario");
        }else if(persona.getContraseñaJugar().equals(contraseña)){
            System.out.printf("Acceso usuario comun");
            rol = "Normalito";
            servicioReal.acceder(persona,contraseña, rol);
        } else if (persona.getContraseñaCrear().equals(contraseña)) {
            System.out.println("Acceso de admin ");
            rol = "Admin";
            servicioReal.acceder(persona,contraseña, rol);
        }
    }
}
