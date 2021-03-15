package pl.kania.base.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kania.base.model.Product;
import pl.kania.base.model.dao.ProductRepository;
import pl.kania.base.model.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("products")
@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    private ResponseEntity<List<ProductDto>> getAllProducts() {
        log.info("Returning all products");
        List<ProductDto> products = productRepository.findAll()
                .stream()
                .map(Product::dto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }
}
