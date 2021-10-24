/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Interface;

import com.reto3Quadbike.Reto3.Model.Quadbike;
import org.springframework.data.repository.CrudRepository;

/**
 * QuadbikeInterface
 * Esta interface implementa el Repository que es manejado por JPA de la tabla y la clase Quadbike
 * 
 * 
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
public interface QuadbikeInterface extends CrudRepository<Quadbike, Integer> {
    
}
