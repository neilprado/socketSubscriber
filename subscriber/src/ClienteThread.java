import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteThread extends Thread {
    private Socket admin;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    public ClienteThread(Socket cliente) throws IOException {
        this.admin = cliente;
        this.outputStream = new DataOutputStream(cliente.getOutputStream());
        this.inputStream = new DataInputStream(cliente.getInputStream());
    }

    public DataOutputStream getOutputStream(){
        return this.outputStream;
    }

    public void run(){
        try {
            String message = this.inputStream.readUTF();
            String[] m = message.split(" ");
            String acao = m[0];
            Boolean envio = false;
            while (true){
                switch (acao){
                    case "subscribe":
                        Topico topico = Dados.topicos.get(m[1]);
                        if(topico != null && envio == false){
                            envio = true;
                            topico.subscribe(this);
                            outputStream.writeUTF("Inscrito em: " + m[1]);
                        }else if(envio == false){
                            outputStream.writeUTF("O tópico não existe");
                        }
                        break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
