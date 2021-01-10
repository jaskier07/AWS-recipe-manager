package pl.kania.database.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kania.database.model.Product;
import pl.kania.database.model.dao.ProductRepository;

import java.util.List;

@RequestMapping("products")
@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }
}
