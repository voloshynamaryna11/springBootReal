package startspringboot.demo.service.impl;

import com.opencsv.CSVReader;
import startspringboot.demo.exception.FileReaderException;
import startspringboot.demo.service.FileReaderService;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<List<String>> read(String path) {
        CSVReader reader;
        List<List<String>> list = new ArrayList<>();
        try {
            reader = new CSVReader(new FileReader(path));
            String[] line;
            while ((line = reader.readNext()) != null) {
                list.add(Arrays.stream(line).collect(Collectors.toList()));
            }
        } catch (IOException e) {
            throw new FileReaderException("File not found!", e);
        }
        return list;
    }
}