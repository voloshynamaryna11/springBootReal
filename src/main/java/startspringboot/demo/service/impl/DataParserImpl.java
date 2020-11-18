package startspringboot.demo.service.impl;

import startspringboot.demo.dto.DataDto;
import startspringboot.demo.service.DataParser;
import java.util.List;

public class DataParserImpl implements DataParser {
    @Override
    public DataDto parseRow(List<String> list) {
        DataDto dataDto = new DataDto();
        dataDto.setId(Long.parseLong(list.get(0)));
        dataDto.setProductId(list.get(1));
        dataDto.setUserId(list.get(2));
        dataDto.setProfileName(list.get(3));
        dataDto.setHelpfulnessNumerator(Long.valueOf(list.get(4)));
        dataDto.setHelpfulnessDenominator(Long.valueOf(list.get(5)));
        dataDto.setScore(Long.valueOf(list.get(6)));
        dataDto.setTime(list.get(7));
        dataDto.setSummary(list.get(8));
        dataDto.setText(list.get(9));
        return dataDto;
    }
}
