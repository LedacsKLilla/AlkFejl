/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.fridgemanager.repositories;

import hu.elte.fridgemanager.entities.UserHistory;
import org.springframework.data.repository.CrudRepository;

public interface UserHistoryRepository extends CrudRepository<UserHistory, Integer>{
    
}
