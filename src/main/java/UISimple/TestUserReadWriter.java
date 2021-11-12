package UISimple;

import usecase.UserManager;

import java.io.Serializable;

public class TestUserReadWriter implements ReadWriter {
    @Override
    public UserManager read(String path) {
        UserManager um = new UserManager();
        um.register("jerry", "pw");
        return um;
    }

    @Override
    public void write(Serializable object) {

    }
}
