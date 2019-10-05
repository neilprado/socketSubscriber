import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class AdministradorThread extends Thread {
    private Socket admin;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    public AdministradorThread(Socket cliente) throws IOException {
        this.admin = cliente;
        this.outputStream = new DataOutputStream(cliente.getOutputStream());
        this.inputStream = new DataInputStream(cliente.getInputStream());
    }

    public DataOutputStream getOutputStream(){
        return this.outputStream;
    }

    public void run(){
        while (true){
            try {
                String message = this.inputStream.readUTF();
                String[] m = message.split(" ");
                String acao = m[0];

                switch(acao){
                    case "topicos":
                        outputStream.writeUTF(Dados.topicos.toString());
                        break;
                    case "create":
                        Dados.topicos.put(m[1], new Topico(m[1]));
                        outputStream.writeUTF("Tópico " + m[1] + " criado com sucesso");
                        break;
                    case "write":
                        if(m.length < 3){
                            outputStream.writeUTF("Chamada inválida, tente novamente");
                        }else{
                            Topico topico = Dados.topicos.get(m[1]);
                            topico.addMessage(m[2]);
                            List<ClienteThread> subs = topico.getSubscribers();
                            for (ClienteThread s : subs){

                            }
                            break;
                        }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
