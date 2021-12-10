package usecase_user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.*;

public class UserManagerTest {
    UserReadWriterForTest testURW = new UserReadWriterForTest();
    UserManager testUM = new UserManager(testURW);

    @Test
    public void testHasUser() {
        assertTrue(testUM.hasUser("testuser"));
    }

    @Test
    public void testLogin() {
        assertTrue(testUM.login("testuser", "testpassword"));
    }

    @Test
    public void testRegister() throws IOException {
        File file = new File("test_data/TestUserInfo.ser");
        if (file.delete()) {
            Path source = new File("test_data/backup/TestUserInfo.ser").toPath();
            Path dest = new File("test_data/TestUserInfo.ser").toPath();
            Files.copy(source, dest, REPLACE_EXISTING);
        }
        boolean b1 = testUM.register("register", "register");
        boolean b2 = testUM.hasUser("register");
        if (file.delete()) {
            Path source = new File("test_data/backup/TestUserInfo.ser").toPath();
            Path dest = new File("test_data/TestUserInfo.ser").toPath();
            Files.copy(source, dest, REPLACE_EXISTING);
        }
        assertTrue(b1 && b2);
    }
}
