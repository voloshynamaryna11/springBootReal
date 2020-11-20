package startspringboot.demo.service.impl;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImplTest {
    private static final String EMPTY_FILE_PATH = "src\\test\\resources\\empty";
    private static final String NOT_REAL_FILE_PATH = "src\\test\\resources\\some";
    private static final String FILE_PATH = "src\\test\\resources\\okfile";
    private FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();

    @Test()
    public void test_empty() {
        List<List<String>> list = new ArrayList<>();
        Assert.assertEquals(list, fileReaderService.read(EMPTY_FILE_PATH));
    }

    @Test(expected = RuntimeException.class)
    public void test_not_real() {
        fileReaderService.read(NOT_REAL_FILE_PATH);
    }

    @Test
    public void test_ok() {
        List<List<String>> expectedList = new ArrayList<>();
        List<String> row = new ArrayList<>();
        row.add("812");
        row.add("B0030C9A60");
        row.add("APNMGFU73W7ZC");
        row.add("Sharon Knibbe");
        row.add("0");
        row.add("0");
        row.add("5");
        row.add("1323388800");
        row.add("Scottie");
        row.add("The holiday liquor cups were exactly what I was looking for."
                + "  The chocolate is<br />delicious and holds up well to the liquors");
        expectedList.add(row);
        Assert.assertEquals(expectedList,
                fileReaderService.read(FILE_PATH));
    }
}
