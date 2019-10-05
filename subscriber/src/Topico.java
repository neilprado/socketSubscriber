import java.util.ArrayList;
import java.util.List;

public class Topico {
    private String nome;
    private List<ClienteThread> subscribers;
    private List<String> messages;

    public Topico(String nome){
        this.nome = nome;
        this.subscribers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public boolean subscribe(ClienteThread socket){
        if(this.subscribers.indexOf(socket) == -1){
            this.subscribers.add(socket);
            return true;
        }else{
            return false;
        }
    }

    public List<ClienteThread> getSubscribers(){
        return this.subscribers;
    }

    public void addMessage(String mensagem){
        this.messages.add(mensagem);
    }

    @Override
    public String toString() {
        return nome + '\n';
    }
}
