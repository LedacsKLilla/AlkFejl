
package hu.elte.fridgemanager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.fridgemanager.entities.Recipe;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import hu.elte.fridgemanager.repositories.RecipeRepository;
import hu.elte.fridgemanager.entities.Ingredient;
import hu.elte.fridgemanager.repositories.IngredientRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/recipe")
public class RecipeController {
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    @Autowired
    private IngredientRepository ingredientRepository;
    
    
    @GetMapping("")
    public ResponseEntity<Iterable<Recipe>> getAll(){
        return ResponseEntity.ok(recipeRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable Integer id){
       Optional<Recipe> oRecipe =  recipeRepository.findById(id);
       if (oRecipe.isPresent()){
            return ResponseEntity.ok(oRecipe.get());
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
    
    @PostMapping("")
    public ResponseEntity<Recipe> insert(@RequestBody Recipe recipe){
        return ResponseEntity.ok(recipeRepository.save(recipe));
    }
    
    @PutMapping("/{id}")
        public ResponseEntity<Recipe> update (@PathVariable Integer id, @RequestBody Recipe recipe){
        Optional<Recipe> oRecipe =  recipeRepository.findById(id);
       if (oRecipe.isPresent()){
           recipe.setId(id);
            return ResponseEntity.ok(recipeRepository.save(recipe));
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
        
    @DeleteMapping("/{id}")
        public ResponseEntity<Recipe> delete (@PathVariable Integer id){
        Optional<Recipe> oRecipe =  recipeRepository.findById(id);
       if (oRecipe.isPresent()){
           recipeRepository.deleteById(id);
            return ResponseEntity.ok().build();
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
        
    @GetMapping("/{id}/ingredients")
     public ResponseEntity<Iterable<Ingredient>> ingredients (@PathVariable Integer id){
       Optional<Recipe> oRecipe =  recipeRepository.findById(id);
       if (oRecipe.isPresent()){
            return ResponseEntity.ok(oRecipe.get().getIngredients());
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
     
     @PostMapping("/{id}/ingredients")
     public ResponseEntity<Ingredient> addIngredient (@RequestBody Ingredient ingredient,@PathVariable Integer id){
       Optional<Recipe> oRecipe =  recipeRepository.findById(id);
       if (oRecipe.isPresent()){
           Recipe recipe = oRecipe.get();
           Ingredient newIngredient = ingredientRepository.save(ingredient);
           recipe.getIngredients().add(newIngredient);
           recipeRepository.save(recipe);
           return ResponseEntity.ok(newIngredient);

       }
       else{
           return ResponseEntity.notFound().build();
       }
         
    }
    
}
