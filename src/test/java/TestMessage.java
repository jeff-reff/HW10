import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMessage {
    @Test
    public void testGetSender(){
        ChatServer server = new ChatServer();
        User user1 = new User("bob", server);
        User user2 = new User("jake", server);

        Message message = new Message(user1, List.of(user2), "hello world");

        assertEquals(user1, message.getSender());
    }

//    @Test
//    public void testGetRecipients(){
//        String user1 = "bob";
//        String user2 = "jake";
//
//        Message message = new Message(user1, List.of(user2), "hello world");
//
//        assertEquals(List.of(user2), message.getRecipients());
//    }

//    @Test
//    public void testGetTimestamp(){
//        String user1 = "bob";
//        String user2 = "jake";
//
//        Message message = new Message(user1, List.of(user2), "hello world");
//
//        assertNotNull(message.getTimestamp());
//    }
//
//    @Test
//    public void testGetMessageContent(){
//        ChatServer server = new ChatServer();
//        User user1 = new User("bob", server);
//        User user2 = new User("jake", server);
//
//        Message message = new Message(user1, List.of(user2), "hello world");
//
//        assertEquals("hello world", message.getMessageContent());
//    }
//
//    @Test
//    public void testToString(){
//        String user1 = "bob";
//        String user2 = "jake";
//
//        Message message = new Message(user1, List.of(user2), "hello world");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//        assertEquals("[" + message.getTimestamp().format(formatter) + "] bob -> [jake]: hello world", message.toString());
//    }
}
