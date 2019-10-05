import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
    public static void main(String[] args) throws IOException {
        System.out.println("=== ==Cliente 2== ===");
        Socket socket = new Socket("127.0.0.1", 7001);
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        DataInputStream input = new DataInputStream(socket.getInputStream());

        Scanner keyboard = new Scanner(System.in);
        output.writeUTF(keyboard.nextLine());
        while (true){
            String message = input.readUTF();
            System.out.println(message);
        }
    }
}
