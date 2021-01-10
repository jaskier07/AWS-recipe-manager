package pl.kania.database.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kania.database.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
