package startspringboot.demo.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.model.Comment;
import java.time.LocalDateTime;

public class CommentMapperTest {
    private DataDto dataDtoOk = new DataDto();
    CommentMapper commentMapper = new CommentMapper();

    @Before
    public void init() {
        dataDtoOk.setId(4L);
        dataDtoOk.setHelpfulnessNumerator(5L);
        dataDtoOk.setHelpfulnessDenominator(10L);
        dataDtoOk.setText("something");
        dataDtoOk.setScore(15L);
        dataDtoOk.setSummary("the end");
        dataDtoOk.setTime(LocalDateTime.of(2020, 11, 23, 19, 37));
    }

    @Test
    public void map_ok() {
        Comment expectedComment = new Comment();
        expectedComment.setCommentId(4L);
        expectedComment.setTime(LocalDateTime.of(2020, 11, 23, 19, 37));
        expectedComment.setText("something");
        expectedComment.setScore(15L);
        expectedComment.setSummary("the end");
        expectedComment.setHelpfulnessDenominator(10L);
        expectedComment.setHelpfulnessNumerator(5L);
        Assert.assertEquals(expectedComment, commentMapper.mapToComment(dataDtoOk));
    }

    @Test
    public void map_without_some_data() {
        DataDto dataDto = new DataDto();
        dataDto.setId(1L);
        Comment comment = new Comment();
        comment.setCommentId(1L);
        Assert.assertEquals(comment, commentMapper.mapToComment(dataDto));
    }
}
