public class User {
    private final String userName;
    private Message lastMessageSent;

    public User(String userName){
        this.userName = userName;
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
