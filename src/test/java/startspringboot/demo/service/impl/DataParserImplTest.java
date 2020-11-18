package startspringboot.demo.service.impl;

import org.junit.Assert;
import org.junit.Test;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.service.DataParser;
import startspringboot.demo.service.FileReaderService;
import java.util.ArrayList;
import java.util.List;

public class DataParserImplTest {
    FileReaderService fileReaderService = new FileReaderServiceImpl();
    DataParser dataParser = new DataParserImpl();
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
        dataDto.setTime("1323388800");
        dataDto.setSummary("Scottie");
        dataDto.setText("The holiday liquor cups were exactly what I was looking for."
                + "  The chocolate is<br />delicious and holds up well to the liquors");
        Assert.assertEquals(dataDto.getId(),
                dataParser.parseRow(data.get(0)).getId());
        Assert.assertEquals(dataDto.getProductId(),
                dataParser.parseRow(data.get(0)).getProductId());
        Assert.assertEquals(dataDto.getUserId(),
                dataParser.parseRow(data.get(0)).getUserId());
        Assert.assertEquals(dataDto.getHelpfulnessNumerator(),
                dataParser.parseRow(data.get(0)).getHelpfulnessNumerator());
        Assert.assertEquals(dataDto.getHelpfulnessDenominator(),
                dataParser.parseRow(data.get(0)).getHelpfulnessDenominator());
        Assert.assertEquals(dataDto.getScore(),
                dataParser.parseRow(data.get(0)).getScore());
        Assert.assertEquals(dataDto.getTime(),
                dataParser.parseRow(data.get(0)).getTime());
        Assert.assertEquals(dataDto.getSummary(),
                dataParser.parseRow(data.get(0)).getSummary());
        Assert.assertEquals(dataDto.getText(),
                dataParser.parseRow(data.get(0)).getText());
    }

    @Test(expected = IndexOutOfBoundsException.class)
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
