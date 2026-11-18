import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    @Test
    public void testGetUserName() {
        String userName = "bob";
        User user1 = new User(userName);
        assertEquals(userName, user1.getUserName());
    }

}
