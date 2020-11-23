package startspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import startspringboot.demo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
