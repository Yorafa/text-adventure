package GuiController;

import entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserControllerTest {
    UserController userController;

    @Before
    public void setUserManager(){
        userController = new UserController();
    }

    @Test(timeout = 50)
    public void testSetUsersAndGetUsers(){
        assertEquals(new ArrayList<>(), userController.getUsers());
        List<User> users = new ArrayList<>();
        users.add(new User("test", "test"));
        userController.setUsers(users);
        assertEquals(users, userController.getUsers());
    }

    @Test(timeout = 50)
    public void testAddUserAndDeleteUser(){
        User testUser = new User("test", "test");
        userController.addUser(testUser);
        List<User> users = new ArrayList<>();
        users.add(testUser);
        assertEquals(users, userController.getUsers());
        userController.deleteUser(testUser);
        assertEquals(new ArrayList<>(), userController.getUsers());
    }

    @Test(timeout = 50)
    public void testHasUser(){
        User testUser = new User("test", "test");
        userController.addUser(testUser);
        assertTrue(userController.hasUser("test"));
        assertTrue(userController.hasUser(testUser));
    }

    @Test(timeout = 50)
    public void testGetUser(){
        User testUser = new User("test", "test");
        userController.addUser(testUser);
        assertNull(userController.getUser("none"));
        assertEquals(testUser, userController.getUser(testUser));
        assertEquals(testUser, userController.getUser("test"));
    }

    @Test(timeout = 50)
    public void testLogin(){
        User testUser = new User("test", "test");
        userController.addUser(testUser);
        User loginUser = userController.login("test", "test");
        assertEquals(testUser, loginUser);
        User nullUser = userController.login("", "");
        assertNull(nullUser);
    }

    @Test(timeout = 50)
    public void testRegister(){
        User testUser = new User("test", "test");
        userController.addUser(testUser);
        User nullUser = userController.register("test", "test");
        assertNull(nullUser);
        User nullUser2 = userController.register("nullAccount", "test");
        assertNull(nullUser2);
        User successUser = userController.register("newAccount", "asd1234r");
        assertEquals(successUser, userController.getUser(successUser));
    }
}
