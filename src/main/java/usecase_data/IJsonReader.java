package usecase_data;

import java.io.IOException;

public interface IJsonReader<T> {
    T read() throws IOException;
}
