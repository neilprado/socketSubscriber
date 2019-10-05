import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        System.out.println("=== ==Server== ===");
        ServerSocket socket = new ServerSocket(7001);
        Socket admin = socket.accept();
        AdministradorThread threadAdmin = new AdministradorThread(admin);
        threadAdmin.start();

        while (true){
            Socket cliente = socket.accept();
            ClienteThread threadCliente = new ClienteThread(cliente);
            threadCliente.start();
        }
    }
}
