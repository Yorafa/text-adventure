package UISimple;

import java.io.*;

public class ReadWriter {
    public Object read(String filePath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        Object o = input.readObject();
        input.close();
        return o;
    }

    public void write(String filePath, Object o) throws IOException {
        FileOutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(o);
        output.close();
    }
}
