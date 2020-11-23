package startspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import startspringboot.demo.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
