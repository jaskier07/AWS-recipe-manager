package pl.kania.base.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kania.base.model.Recipe;
import pl.kania.base.model.AmountType;
import pl.kania.base.model.ProductQuantity;
import pl.kania.base.model.Product;
import pl.kania.base.model.dao.ProductQuantityRepository;
import pl.kania.base.model.dao.RecipeRepository;
import pl.kania.base.model.dao.ProductRepository;

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

        Recipe sandwich = new Recipe("Sandwich", "Sandwich - short description", "Sandwich - description");

        ProductQuantity breadQuantity = new ProductQuantity(new Product("Bread"), sandwich, 2, AmountType.ITEM);
        ProductQuantity butterAmount = new ProductQuantity(new Product("Butter"), sandwich, 50, AmountType.GRAM);

        sandwich.getProducts().add(breadQuantity);
        sandwich.getProducts().add(butterAmount);
        sandwich = recipeRepository.save(sandwich);

        log.info("Initial fixture finished");
    }
}
