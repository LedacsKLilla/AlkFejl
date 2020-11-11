/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.fridgemanager.controllers;

import hu.elte.fridgemanager.entities.Fridge;
import hu.elte.fridgemanager.repositories.FridgeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Ruu
 */
public class FridgeController {
    
         
    @Autowired
    private FridgeRepository fridgeRepository;
    
    
    @PostMapping("")
    public ResponseEntity<Fridge> insert(@RequestBody Fridge fridge){
        return ResponseEntity.ok(fridgeRepository.save(fridge));
    }
    
    @PutMapping("/{id}")
        public ResponseEntity<Fridge> update (@PathVariable Integer id, @RequestBody Fridge fridge){
        Optional<Fridge> oRecipe =  fridgeRepository.findById(id);
       if (oRecipe.isPresent()){
           fridge.setId(id);
            return ResponseEntity.ok(fridgeRepository.save(fridge));
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
    @Secured({ "ROLE_ADMIN" })
    @DeleteMapping("/{id}")
        public ResponseEntity<Fridge> delete (@PathVariable Integer id){
        Optional<Fridge> oFridge =  fridgeRepository.findById(id);
       if (oFridge.isPresent()){
           fridgeRepository.deleteById(id);
            return ResponseEntity.ok().build();
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }
    
}
