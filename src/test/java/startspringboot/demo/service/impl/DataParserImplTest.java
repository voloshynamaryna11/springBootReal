package startspringboot.demo.service.impl;

import org.junit.Assert;
import org.junit.Test;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.exception.EmptyFileException;
import startspringboot.demo.service.DataParser;
import startspringboot.demo.service.FileReaderService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DataParserImplTest {
    private FileReaderService fileReaderService = new FileReaderServiceImpl();
    private DataParser dataParser = new DataParserImpl();
    private static final String FILE_PATH = "src\\test\\resources\\okfile";

    @Test
    public void test_ok() {
        List<List<String>> data = fileReaderService.read(FILE_PATH);
        DataDto dataDto = new DataDto();
        dataDto.setId(812L);
        dataDto.setProductId("B0030C9A60");
        dataDto.setUserId("APNMGFU73W7ZC");
        dataDto.setHelpfulnessNumerator(0L);
        dataDto.setHelpfulnessDenominator(0L);
        dataDto.setScore(5L);
        dataDto.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1323388800L), ZoneId.systemDefault()));
        dataDto.setSummary("Scottie");
        dataDto.setText("The holiday liquor cups were exactly what I was looking for."
                + "  The chocolate is<br />delicious and holds up well to the liquors");
        DataDto actual = dataParser.parseRow(data.get(0));
        Assert.assertEquals(dataDto.getId(),actual.getId());
        Assert.assertEquals(dataDto.getProductId(),
                 actual.getProductId());
        Assert.assertEquals(dataDto.getUserId(),
                 actual.getUserId());
        Assert.assertEquals(dataDto.getHelpfulnessNumerator(),
                 actual.getHelpfulnessNumerator());
        Assert.assertEquals(dataDto.getHelpfulnessDenominator(),
                 actual.getHelpfulnessDenominator());
        Assert.assertEquals(dataDto.getScore(),
                 actual.getScore());
        Assert.assertEquals(dataDto.getTime(),
                 actual.getTime());
        Assert.assertEquals(dataDto.getSummary(),
                 actual.getSummary());
        Assert.assertEquals(dataDto.getText(),
                 actual.getText());
    }

    @Test(expected = EmptyFileException.class)
    public void test_empty() {
        List<String> list = new ArrayList<>();
        dataParser.parseRow(list);
    }

    @Test(expected = NumberFormatException.class)
    public void test_invalid() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        dataParser.parseRow(list);
    }
}
