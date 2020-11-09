
package hu.elte.fridgemanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hu.elte.fridgemanager.entities.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer>{

    
}
