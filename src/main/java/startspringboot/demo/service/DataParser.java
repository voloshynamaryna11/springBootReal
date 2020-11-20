package startspringboot.demo.service;

import startspringboot.demo.dto.DataDto;

import java.util.List;

public interface DataParser {
    DataDto parseRow(List<String> list);
}
