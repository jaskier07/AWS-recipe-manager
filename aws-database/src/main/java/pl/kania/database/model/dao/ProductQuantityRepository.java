package pl.kania.database.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kania.database.model.ProductQuantity;
import pl.kania.database.model.ProductQuantityPK;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity, ProductQuantityPK> {
}
