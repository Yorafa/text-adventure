package entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private final User user = new User("test name", "test password");

    @Test(timeout = 50)
    public void testGetUserNameAndSetUserName() {
        assertEquals("test name", user.getUsername());
        user.setUsername("new");
        assertEquals("new", user.getUsername());
    }

    @Test(timeout = 50)
    public void testGetUserPasswordAndSetPassword() {
        assertEquals("test password", user.getPassword());
        user.setPassword("new");
        assertEquals("new", user.getPassword());
    }

    @Test(timeout = 50)
    public void testEqual() {
        User testUser = new User("test name", "test password");
        assertEquals(user, testUser);
    }
}
