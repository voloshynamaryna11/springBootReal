package startspringboot.demo.service.impl;

import startspringboot.demo.dto.DataDto;
import startspringboot.demo.exception.EmptyFileException;
import startspringboot.demo.service.DataParser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class DataParserImpl implements DataParser {
    @Override
    public DataDto parseRow(List<String> list) {
        DataDto dataDto = new DataDto();
        if (list.isEmpty()) {
            throw new EmptyFileException("Can`t parse empty file");
        }
        dataDto.setId(Long.parseLong(list.get(0)));
        dataDto.setProductId(list.get(1));
        dataDto.setUserId(list.get(2));
        dataDto.setProfileName(list.get(3));
        dataDto.setHelpfulnessNumerator(Long.valueOf(list.get(4)));
        dataDto.setHelpfulnessDenominator(Long.valueOf(list.get(5)));
        dataDto.setScore(Long.valueOf(list.get(6)));
        dataDto.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                Long.parseLong(list.get(7))), ZoneId.systemDefault()));
        dataDto.setSummary(list.get(8));
        dataDto.setText(list.get(9));
        return dataDto;
    }
}
