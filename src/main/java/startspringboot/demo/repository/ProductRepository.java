package startspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import startspringboot.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
