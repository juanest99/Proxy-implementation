import Jugadores.*;
import proxy.*;

import javax.swing.*;

void main() {
    boolean cicle = false;
    int opt=0;
    String menu = """
            Bienvenido a wordle 
            1. Registrarme
            2. Jugar
            """;
    do{
    String message = JOptionPane.showInputDialog(null,menu);
        try {
            opt = Integer.parseInt(message);
            cicle = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }while(cicle== false || opt<=0 || opt>3);

    switch (opt) {
        case 1:
            String nombre = JOptionPane.showInputDialog(null,"Indica nombre de usuario");
            String contraseñaJugar = JOptionPane.showInputDialog(null, "Ingresa tu contraseña de jugador");
            String contraseñaCrear = JOptionPane.showInputDialog(null, "Ingresa tu contraseña para crear");
            if(nombre.isEmpty() || contraseñaJugar.isEmpty() || contraseñaCrear.isEmpty()){
                JOptionPane.showMessageDialog(null,"Ingresa los datos de manera correctamente");
            }else{
                Persona persona = new Persona(nombre,contraseñaJugar,contraseñaCrear);
                registroData.guardarUsuario(persona);
                JOptionPane.showMessageDialog(null,"Usuario registrado correctamente");
            }
            break;
        case 2:
             nombre = JOptionPane.showInputDialog(null,"Indica nombre de usuario");
            String contraseña = JOptionPane.showInputDialog(null, "Ingresa tu contraseña de jugador");
            if(nombre.isEmpty() || contraseña.isEmpty()){
                JOptionPane.showMessageDialog(null, " Ingresaste datos de forma erronea ");
            }
            Login login = new LoginVerificar();
            Persona p = login.login(nombre,contraseña);
            String rol ="";
            Service proxy = new ProxyServicio();
            proxy.acceder(p,contraseña,rol);
            break;
    }
}
