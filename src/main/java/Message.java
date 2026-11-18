import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Message {
    private final User sender;
    private final List<User> recipients;
    private final LocalDateTime timestamp;
    private final String messageContent;

    public Message (User sender, List<User> recipients, String messageContent){
        this.sender = sender;
        this.recipients = recipients;
        this.messageContent = messageContent;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender(){
        return sender;
    }

    public List<User> getRecipients(){
        return recipients;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public String getMessageContent(){
        return messageContent;
    }

    @Override
    public String toString(){
        String time = timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return "[" + time + "] " + sender + " -> " + recipients + ": " + messageContent;
    }
}
