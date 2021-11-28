package usecase;

import entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserManagerTest {
    UserManager userManager;

    @Before
    public void setUserManager(){
        userManager = new UserManager();
    }

    @Test(timeout = 50)
    public void testSetUsersAndGetUsers(){
        assertEquals(new ArrayList<>(), userManager.getUsers());
        List<User> users = new ArrayList<>();
        users.add(new User("test", "test"));
        userManager.setUsers(users);
        assertEquals(users, userManager.getUsers());
    }

    @Test(timeout = 50)
    public void testAddUserAndDeleteUser(){
        User testUser = new User("test", "test");
        userManager.addUser(testUser);
        List<User> users = new ArrayList<>();
        users.add(testUser);
        assertEquals(users, userManager.getUsers());
        userManager.deleteUser(testUser);
        assertEquals(new ArrayList<>(), userManager.getUsers());
    }

    @Test(timeout = 50)
    public void testHasUser(){
        User testUser = new User("test", "test");
        userManager.addUser(testUser);
        assertTrue(userManager.hasUser("test"));
        assertTrue(userManager.hasUser(testUser));
    }

    @Test(timeout = 50)
    public void testGetUser(){
        User testUser = new User("test", "test");
        userManager.addUser(testUser);
        assertNull(userManager.getUser("none"));
        assertEquals(testUser, userManager.getUser(testUser));
        assertEquals(testUser, userManager.getUser("test"));
    }

    @Test(timeout = 50)
    public void testLogin(){
        User testUser = new User("test", "test");
        userManager.addUser(testUser);
        User loginUser = userManager.login("test", "test");
        assertEquals(testUser, loginUser);
        User nullUser = userManager.login("", "");
        assertNull(nullUser);
    }

    @Test(timeout = 50)
    public void testRegister(){
        User testUser = new User("test", "test");
        userManager.addUser(testUser);
        User nullUser = userManager.register("test", "test");
        assertNull(nullUser);
        User nullUser2 = userManager.register("nullAccount", "test");
        assertNull(nullUser2);
        User successUser = userManager.register("newAccount", "asd1234r");
        assertEquals(successUser, userManager.getUser(successUser));
    }
}
