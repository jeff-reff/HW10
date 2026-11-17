import java.time.LocalDateTime;
import java.util.List;

public class Message {
    private final String sender;
    private final List<String> recipients;
    private final LocalDateTime timestamp;
    private final String messageContent;

    public Message (String sender, List<String> recipients, String messageContent){
        this.sender = sender;
        this.recipients = recipients;
        this.messageContent = messageContent;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender(){
        return sender;
    }

    public List<String> getRecipients(){
        return null;
    }

    public LocalDateTime getTimestamp(){
        return null;
    }

    public boolean isUserInvolved (String user){
        return false;
    }


}
