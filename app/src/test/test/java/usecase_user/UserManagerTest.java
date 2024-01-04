package usecase_user;

import org.junit.Before;
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

    @Before
    public void setUp() throws IOException {
        if (new File("test_data/UserInfo.ser").delete()) {
            Path source = new File("test_data/backup/UserInfo.ser").toPath();
            Path dest = new File("test_data/UserInfo.ser").toPath();
            Files.copy(source, dest, REPLACE_EXISTING);
        }
    }

    @Test
    public void testHasUser() {
        assertTrue(testUM.hasUser("testuser"));
    }

    @Test
    public void testLogin() {
        assertTrue(testUM.login("testuser", "testpassword"));
    }

    @Test
    public void testRegister() {
        assertTrue(testUM.register("register", "register"));
        assertTrue(testUM.hasUser("register"));
    }
}
