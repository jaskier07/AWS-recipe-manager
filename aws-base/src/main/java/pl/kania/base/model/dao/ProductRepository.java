package pl.kania.base.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kania.base.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
