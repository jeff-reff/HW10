import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    @Test
    public void testGetUserName() {
        ChatServer server = new ChatServer();
        User user1 = new User("bob", server);

        assertEquals("bob", user1.getUserName());
    }

    //testing if a user can send messages to one or more other users through the chat server
    @Test
    public void testSendMessage() {
        ChatServer server = new ChatServer();
        User user1 = new User("bob", server);
        User user2 = new User("jake", server);
        User user3 = new User("dave", server);

        user1.sendMessage("Hello jake and dave", user2, user3);

        assertEquals(1, user2.viewChatHistory().size());
        assertEquals(1, user3.viewChatHistory().size());
    }

    //testing if a user can undo the last message they sent with the Memento design pattern
    @Test
    public void testUndoLastMessage(){
        ChatServer server = new ChatServer();
        User user1 = new User("bob", server);
        User user2 = new User("jake", server);

        user1.sendMessage("Hello jake", user2);

        assertEquals(1, user2.viewChatHistory().size());

        user1.undoLastMessage();

        assertEquals(0, user2.viewChatHistory().size());
    }

    @Test
    public void testReceivingMessagesAndViewingChatHistory(){
        ChatServer server = new ChatServer();
        User user1 = new User("bob", server);
        User user2 = new User("jake", server);

        user1.sendMessage("Hello jake", user2);
        List<Message> user1History = user1.viewChatHistory();

        assertEquals(1, user1.viewChatHistory().size());

        assertEquals("Hello jake", user1History.get(0).getMessageContent());
    }
}
