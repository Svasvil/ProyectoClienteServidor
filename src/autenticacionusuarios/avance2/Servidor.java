import java.io.*;
import java.net.*;

public class Servidor {
    private static final int PUERTO = 12345;

    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado en el puerto " + PUERTO);

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());
                
                // Manejar cliente en un hilo separado
                new HiloCliente(cliente).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HiloCliente extends Thread {
    private Socket cliente;

    public HiloCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try (
            InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
            BufferedReader entrada = new BufferedReader(isr);
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)
        ) {
            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                salida.println("Echo: " + mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
