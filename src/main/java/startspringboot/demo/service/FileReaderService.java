package startspringboot.demo.service;

import java.util.List;

public interface FileReaderService {
    public List<List<String>> read(String path, String separator);
}
