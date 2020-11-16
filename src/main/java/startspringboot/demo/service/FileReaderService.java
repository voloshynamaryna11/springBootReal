package startspringboot.demo.service;

import java.util.List;

public interface FileReaderService {
    public static final String SEPARATOR = ",";

    public List<List<String>> read(String path);
}
