import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMessage {
    @Test
    public void testGetSender(){
        String user1 = "bob";
        String user2 = "jake";

        Message message = new Message(user1, List.of(user2), "hello world");

        assertEquals(user1, message.getSender());
    }
}
