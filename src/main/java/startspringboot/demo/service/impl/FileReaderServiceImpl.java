package startspringboot.demo.service.impl;

import startspringboot.demo.exception.FileReaderException;
import startspringboot.demo.service.FileReaderService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<List<String>> read(String path, String separator) {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            if (bufferedReader.readLine() == null) {
                throw new RuntimeException("File is empty");
            }
            while ((line = bufferedReader.readLine()) != null) {
                List<String> row = new ArrayList<>();
                String[] str = line.split(separator);
                for (String dataPieces : str) {
                    row.add(dataPieces);
                }
                data.add(row);
            }
        } catch (IOException e) {
            throw new FileReaderException("File not found!", e);
        }
        return data;
    }
}
