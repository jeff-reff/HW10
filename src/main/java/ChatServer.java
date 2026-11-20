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
            if (users.containsValue(recipient) && !isBlocked(recipient, sender)) {
                recipient.receiveMessage(message);
            } else if (users.containsValue(recipient)){
                System.out.println(recipient.getUserName() + " has a blocked message from " + sender.getUserName());
            }

        }

        return message;
    }

    public void blockUserMessages(User receiver, User blockedUser){
        blockedUsers.computeIfAbsent(receiver, ignored -> new HashSet<>()).add(blockedUser);
        System.out.println(receiver.getUserName() + " blocked receiving messages from " + blockedUser.getUserName());
    }

    public void undoMessage(User sender, Message message){
        sender.removeMessageFromHistory(message);

        for (User recipient : message.getRecipients()){
            recipient.removeMessageFromHistory(message);
        }
    }

    private boolean isBlocked (User receiver, User sender){
        return blockedUsers.getOrDefault(receiver, Set.of()).contains(sender);
    }
}
