package autenticacionusuarios.avance2;

import javax.swing.JOptionPane;

public class AutenticacionUsuariosAvance2 {

    public static void main(String[] args) {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null, "Bienvenido al sistema\n"
                    + "1. Iniciar Sesión\n"
                    + "2. Crear cuenta\n"
                    + "3. Salir");

            try {
                int eleccion = Integer.parseInt(opcion);
                switch (eleccion) {
                    case 1:
                        gestionUsuarios.Login();
                        break;
                    case 2:
                        gestionUsuarios.SingUp();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }
}
