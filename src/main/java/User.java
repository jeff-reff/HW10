import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userName;
    private Message lastMessageSent;
    private final ChatServer server;
    private final ChatHistory chatHistory;
    private MessageMemento messageSnapshot;

    public User(String userName, ChatServer server){
        this.userName = userName;
        this.server = server;
        this.chatHistory = new ChatHistory(this);
        server.registerUser(this);
    }

    public String getUserName(){
        return userName;
    }

    public void sendMessage(String messageContent, User recipients){
        List<User> recipientList = new ArrayList<>(List.of(recipients));
        messageSnapshot = null;
        lastMessageSent = server.sendMessage(this, recipientList, messageContent);
    }

    public void recieveMessage(Message message){

    }

    public void undoLastMessage() {

    }

    public void addMessageToHistory(Message message){
        chatHistory.addMessage(message);
    }

    public void removeMessageFromHistory(Message message){
        chatHistory.removeMessage(message);
    }

    public List<Message> viewChatHistory(){
        return chatHistory.getMessages();
    }
}
