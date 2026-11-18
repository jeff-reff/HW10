import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    @Test
    public void testGetUserName() {
        ChatServer server = new ChatServer();
        User user1 = new User("bob", server);
        User user2 = new User("jake", server);

        assertEquals("bob", user1.getUserName());
    }
//
//    @Test
//    public void testSendMessage() {
//        String userName = "bob";
//        User user1 = new User(userName);
//        assertEquals(userName, user1.getUserName());
//    }

}
