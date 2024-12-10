package autenticacionusuarios.avance2;

import javax.swing.JOptionPane;

public class AutenticacionUsuariosAvance2 {

    public static void main(String[] args) {
        GestionUsuarios g1 = new GestionUsuarios();
        String opc = JOptionPane.showInputDialog(null, "Bienvenido al sistema\n"
                + "Escoja una opción \n"
                + "1. Iniciar Sesión\n"
                + "2. Crear cuenta");
        int eleccion = Integer.parseInt(opc);
        switch (eleccion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Iniciando Sesión");
                g1.Login();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Creando Cuenta");
                g1.SingUp();
                String opc2 = JOptionPane.showInputDialog(null, "Desea ver los datos de la cuenta \n"
                        + "1.si\n"
                        + "2.no");
                int eleccion2 = Integer.parseInt(opc2);

                switch (eleccion2) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Mostrando datos de la cuenta creada");
                        g1.VerDatosCuentaCreada();
                        String opc3 = JOptionPane.showInputDialog("desea modificar algun dato?\n"
                                + "1.si\n"
                                + "2.no");
                        int eleccion3 = Integer.parseInt(opc3);

                        switch (eleccion3) {
                            case 1:
                                String opc4 = JOptionPane.showInputDialog("Cual dato desea modificar\n"
                                        + "1.ID\n"
                                        + "2.Nombre de usuario\n"
                                        + "3.Contrasena");
                                int eleccion4 = Integer.parseInt(opc4);
                                switch (eleccion4) {
                                    case 1:
                                        g1.ModificarID();
                                        JOptionPane.showMessageDialog(null, "Dato modificado correctamente");
                                        break;
                                    case 2:
                                        g1.ModificarNombre();
                                        JOptionPane.showMessageDialog(null, "Dato modificado correctamente");
                                        break;
                                    case 3:
                                        g1.ModificarContrasena();
                                        JOptionPane.showMessageDialog(null, "Dato modificado correctamente");
                                    default:

                                }
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "No se modificaron datos , se continuara ");
                                break;
                        }
                        JOptionPane.showMessageDialog(null, "Datos Actualizados");
                        g1.VerDatosCuentaCreada2();

                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Continuando con el sistema");
                        break;
                    default:
                }
        }
    }
}
