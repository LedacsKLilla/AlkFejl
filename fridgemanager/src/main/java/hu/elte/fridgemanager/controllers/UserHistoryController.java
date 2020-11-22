/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.fridgemanager.controllers;

import hu.elte.fridgemanager.entities.UserHistory;
import hu.elte.fridgemanager.entities.Recipe;
import hu.elte.fridgemanager.repositories.IngredientRepository;
import hu.elte.fridgemanager.repositories.RecipeRepository;
import hu.elte.fridgemanager.repositories.UserHistoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class UserHistoryController {
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    @Autowired
    private UserHistoryRepository userHistoryRepository;
    
    
    @GetMapping("")
    public ResponseEntity<Iterable<Recipe>> getAll(){
        return ResponseEntity.ok(recipeRepository.findAll());
    }
    
    
     @Secured({ "ROLE_USER", "ROLE_ADMIN" })
     @PostMapping("/{id}/recipes")
     public ResponseEntity<Recipe> addRecipes (@RequestBody Recipe recipe,@PathVariable Integer id){
       Optional<UserHistory> oUserHis =  userHistoryRepository.findById(id);
       if (oUserHis.isPresent()){
           UserHistory userHistory = oUserHis.get();
           Recipe newRecipe = recipeRepository.save(recipe);
           userHistory.getHistory().add(newRecipe);
           recipeRepository.save(recipe);
           return ResponseEntity.ok(newRecipe);

       }
       else{
           return ResponseEntity.notFound().build();
       }
         
    }
    
}
