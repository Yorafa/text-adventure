package usecase_user;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.assertTrue;

public class UserManagerTest {
    final UserReadWriterForTest testURW = new UserReadWriterForTest();
    final UserManager testUM = new UserManager(testURW);

    public void prepForTest() throws IOException {
        if (new File("test_data/TestUserInfo.ser").delete()) {
            Path source = new File("test_data/backup/TestUserInfo.ser").toPath();
            Path dest = new File("test_data/TestUserInfo.ser").toPath();
            Files.copy(source, dest, REPLACE_EXISTING);
        }
    }

    @Test
    public void testHasUser() throws IOException {
        prepForTest();
        assertTrue(testUM.hasUser("testuser"));
    }

    @Test
    public void testLogin() throws IOException {
        prepForTest();
        assertTrue(testUM.login("testuser", "testpassword"));
    }

    @Test
    public void testRegister() throws IOException {
        prepForTest();
        boolean b1 = testUM.register("register", "register");
        boolean b2 = testUM.hasUser("register");
        prepForTest();
        assertTrue(b1 && b2);
    }
}
