package gateway;

import usecase_data.IReadWriter;

import java.io.IOException;

/**
 * the data access object of user
 */
public class UserReadWriter implements IReadWriter {
    private final ReadWriter rw = new ReadWriter();

    /**
     * @return the user data
     * @throws IOException            file not exist exception
     * @throws ClassNotFoundException class not exist exception
     */
    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ConfigReader configReader = new ConfigReader();
        String filePath = configReader.getUserPath();
        return rw.read(filePath);
    }

    /**
     * @param o object will be written
     * @throws IOException file not exist
     */
    @Override
    public void write(Object o) throws IOException {
        ConfigReader configReader = new ConfigReader();
        String filePath = configReader.getUserPath();
        rw.write(filePath, o);
    }
}