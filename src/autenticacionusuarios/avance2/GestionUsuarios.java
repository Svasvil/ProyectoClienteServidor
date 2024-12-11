package autenticacionusuarios.avance2;

import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GestionUsuarios {

    private String[][] usuarios;
    private int contador;

    public GestionUsuarios() {
        usuarios = new String[5][3]; // Columnas: ID, NombreUsuario, Contraseña (hash)
        contador = 0;
    }

    public void SingUp() {
        if (contador >= usuarios.length) {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de usuarios alcanzada.");
            return;
        }

        String id = JOptionPane.showInputDialog("Digite el ID del usuario");
        String nombreUsuario = JOptionPane.showInputDialog("Digite el nombre de usuario");
        String contrasena = JOptionPane.showInputDialog("Digite la contraseña");

        if (id == null || nombreUsuario == null || contrasena == null || id.isEmpty() || nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        usuarios[contador][0] = id;
        usuarios[contador][1] = nombreUsuario;
        usuarios[contador][2] = hashPassword(contrasena);
        contador++;

        JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.");
    }

    public void Login() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }

        String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

        if (nombreUsuario == null || contrasena == null || nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        String hashedPassword = hashPassword(contrasena);

        for (int i = 0; i < contador; i++) {
            if (usuarios[i][1].equals(nombreUsuario) && usuarios[i][2].equals(hashedPassword)) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash de contraseña", e);
        }
    }

    public void VerDatosCuentaCreada() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay cuentas creadas.");
            return;
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            resultado.append("ID: ").append(usuarios[i][0])
                    .append(", Nombre: ").append(usuarios[i][1])
                    .append(", Contraseña: [PROTEGIDA]\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
