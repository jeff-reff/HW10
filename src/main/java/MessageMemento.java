import java.time.LocalDateTime;

public class MessageMemento {
    private final String messageContent;
    private final LocalDateTime timestamp;

    public MessageMemento(String messageContent, LocalDateTime timestamp){
        this.messageContent = messageContent;
        this.timestamp = timestamp;
    }

    public String getMessageContent(){
        return messageContent;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }
}
