package usecase;

import java.io.IOException;

public interface IJsonReader<T> {
    T read() throws IOException;
}
