package startspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import startspringboot.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
