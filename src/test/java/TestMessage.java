import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMessage {
    @Test
    public void testGetSender(){
        String user1 = "bob";
        String user2 = "jake";

        Message message = new Message(user1, List.of(user2), "hello world");

        assertEquals(user1, message.getSender());
    }

    @Test
    public void testGetRecipients(){
        String user1 = "bob";
        String user2 = "jake";

        Message message = new Message(user1, List.of(user2), "hello world");

        assertEquals(List.of(user2), message.getRecipients());
    }

    @Test
    public void testGetTimestamp(){
        String user1 = "bob";
        String user2 = "jake";

        Message message = new Message(user1, List.of(user2), "hello world");

        assertNotNull(message.getTimestamp());
    }
}
