package pl.kania.database.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kania.database.model.AmountType;
import pl.kania.database.model.ProductQuantity;
import pl.kania.database.model.Recipe;
import pl.kania.database.model.Product;
import pl.kania.database.model.dao.ProductQuantityRepository;
import pl.kania.database.model.dao.RecipeRepository;
import pl.kania.database.model.dao.ProductRepository;

@Slf4j
@Service
public class InitialFixture {

    private final RecipeRepository recipeRepository;
    private final ProductRepository productRepository;
    private final ProductQuantityRepository productQuantityRepository;

    @Autowired
    public InitialFixture(RecipeRepository recipeRepository, ProductRepository productRepository, ProductQuantityRepository productQuantityRepository) {
        this.recipeRepository = recipeRepository;
        this.productRepository = productRepository;
        this.productQuantityRepository = productQuantityRepository;
        perform();
    }

    private void perform() {
        log.info("Performing initial fixture");

        Recipe sandwich = new Recipe("Sandwich");

        ProductQuantity breadQuantity = new ProductQuantity(new Product("Bread"), sandwich, 2, AmountType.ITEM);
        ProductQuantity butterAmount = new ProductQuantity(new Product("Butter"), sandwich, 50, AmountType.GRAM);

        sandwich.getProducts().add(breadQuantity);
        sandwich.getProducts().add(butterAmount);
        sandwich = recipeRepository.save(sandwich);

        log.info("Initial fixture finished");
    }
}
