import java.util.ArrayList;
import java.util.List;

public class ChatHistory {
    private final User messageSender;
    private final List<Message> messages = new ArrayList<>();

    public ChatHistory(User messageSender){
        this.messageSender = messageSender;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public Message getLastMessage(){
        for (int i = messages.size()-1; i >= 0; i--){
            if(messages.get(i).getSender().equals(messageSender)){
                return messages.get(i);
            }
        }
        return null;
    }

    public void removeMessage(Message message){
        messages.remove(message);
    }

    public List<Message> getMessages(){
        return new ArrayList<>(messages);
    }
}
