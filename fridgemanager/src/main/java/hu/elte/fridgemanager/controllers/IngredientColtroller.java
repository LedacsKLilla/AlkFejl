/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.fridgemanager.controllers;

import hu.elte.fridgemanager.entities.Ingredient;
import hu.elte.fridgemanager.repositories.IngredientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ruu
 */
@RestController
@RequestMapping("/ingredient")
public class IngredientColtroller {
        
    @Autowired
    private IngredientRepository ingredientRepository;
    
    
    @PostMapping("")
    public ResponseEntity<Ingredient> insert(@RequestBody Ingredient ingredient){
        return ResponseEntity.ok(ingredientRepository.save(ingredient));
    }
    
    @PutMapping("/{id}")
        public ResponseEntity<Ingredient> update (@PathVariable Integer id, @RequestBody Ingredient ingredient){
        Optional<Ingredient> oRecipe =  ingredientRepository.findById(id);
       if (oRecipe.isPresent()){
           ingredient.setId(id);
            return ResponseEntity.ok(ingredientRepository.save(ingredient));
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
    @Secured({ "ROLE_ADMIN" })
    @DeleteMapping("/{id}")
        public ResponseEntity<Ingredient> delete (@PathVariable Integer id){
        Optional<Ingredient> oRecipe =  ingredientRepository.findById(id);
       if (oRecipe.isPresent()){
           ingredientRepository.deleteById(id);
            return ResponseEntity.ok().build();
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
    
}
