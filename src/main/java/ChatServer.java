import java.util.*;

public class ChatServer {
    private final Map<String, User> users = new HashMap<>();
    private final Map<User, Set<User>> blockedUsers = new HashMap<>();

    public void registerUser(User user){
        users.put(user.getUserName(), user);
    }

    public void unregisterUser(User user){
        users.remove(user.getUserName());
        blockedUsers.remove(user);
        for (Set<User> usersBlockedByUnregisteredUser : blockedUsers.values()){
            usersBlockedByUnregisteredUser.remove(user);
        }
    }

    public Message sendMessage(User sender, List<User> recipients, String messageContent) {
        Message message = new Message(sender, recipients, messageContent);
        sender.addMessageToHistory(message);

        for (User recipient : recipients){
            recipient.receiveMessage(message);
        }

        return message;
    }

    public void blockUserMessages(User receiver, User blockedUser){

    }

    public void undoMessage(User sender, Message message){
        
    }
}
