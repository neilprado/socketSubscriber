import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) throws IOException {
        System.out.println("=== ==Admin== ===");
        Socket socket = new Socket("127.0.0.1", 7001);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());

        while (true){
            Scanner keyboard = new Scanner(System.in);
            outputStream.writeUTF(keyboard.nextLine());
            String message = inputStream.readUTF();
            System.out.println(message);
        }
    }
}
