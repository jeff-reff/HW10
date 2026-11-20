import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChatServer {
    //testing if user can block messages from specific users using the Mediator design pattern
    @Test
    public void testBlockMessagesFromUser() {
        ChatServer server = new ChatServer();
        User user1 = new User("bob", server);
        User user2 = new User("jake", server);

        server.blockUserMessages(user1, user2);
        user2.sendMessage("Hello bob", user1);

        assertEquals(0, user1.viewChatHistory().size());
    }
}
