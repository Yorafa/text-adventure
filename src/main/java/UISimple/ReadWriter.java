package UISimple;

import java.io.Serializable;

public interface ReadWriter {
    Object read(String path);
    void write(Serializable object);
}
