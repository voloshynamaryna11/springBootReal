package startspringboot.demo.mapper;

import org.springframework.stereotype.Component;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.model.Comment;

@Component
public class CommentMapper {
    public Comment mapToComment(DataDto dataDto) {
        Comment comment = new Comment();
        comment.setCommentId(dataDto.getId());
        comment.setHelpfulnessDenominator(dataDto.getHelpfulnessDenominator());
        comment.setHelpfulnessNumerator(dataDto.getHelpfulnessNumerator());
        comment.setScore(dataDto.getScore());
        comment.setSummary(dataDto.getSummary());
        comment.setText(dataDto.getText());
        comment.setTime(dataDto.getTime());
        return comment;
    }
}
