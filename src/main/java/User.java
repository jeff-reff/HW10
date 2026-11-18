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

    }

    public void recieveMessage(Message message){

    }

    public void undoLastMessage() {

    }
}
