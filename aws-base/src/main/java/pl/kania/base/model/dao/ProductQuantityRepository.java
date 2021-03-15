package pl.kania.base.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kania.base.model.ProductQuantity;
import pl.kania.base.model.ProductQuantityPK;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity, ProductQuantityPK> {
}
