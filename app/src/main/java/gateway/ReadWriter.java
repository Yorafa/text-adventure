package gateway;

import java.io.*;

/**
 * the data access object
 */
public class ReadWriter {

    /**
     * @param filePath the file path use to get file
     * @return Object by the given filePath
     * @throws IOException            file may not exist
     * @throws ClassNotFoundException class may not exist
     */
    public Object read(String filePath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        Object o = input.readObject();
        input.close();
        return o;
    }

    /**
     * @param filePath the file path use to get file
     * @param o        the object will be written
     * @throws IOException file may not exist
     */
    public void write(String filePath, Object o) throws IOException {
        FileOutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(o);
        output.close();
    }
}