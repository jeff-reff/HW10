import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User implements IterableByUser{
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

    public void sendMessage(String messageContent, User... recipients){
        List<User> recipientList = new ArrayList<>(List.of(recipients));
        messageSnapshot = null;
        lastMessageSent = server.sendMessage(this, recipientList, messageContent);

        if (lastMessageSent != null){
            messageSnapshot = new MessageMemento(lastMessageSent.getMessageContent(), lastMessageSent.getTimestamp());
        }
    }

    public void receiveMessage(Message message){
        addMessageToHistory(message);

        System.out.println(userName + " received message: " + message);
    }

    public void undoLastMessage() {
        if (lastMessageSent == null || messageSnapshot == null) {
            System.out.println("no message to undo from " + userName);
            return;
        }
        System.out.println("undoing - " + messageSnapshot.getMessageContent() + " - from: " + userName);
        server.undoMessage(this, lastMessageSent);
        lastMessageSent = null;
        messageSnapshot = null;
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

    @Override
    public Iterator<Message> iterator(User userToSearchWith){
        return chatHistory.iterator(userToSearchWith);
    }
}
