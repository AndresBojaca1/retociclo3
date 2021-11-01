/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.Interface;

import com.reto5quadbike.reto5.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * ClientInterface
 * Esta interface implementa el Repository que es manejado por JPA de la tabla y la clase Client
 * 
 * 
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
public interface ClientInterface extends CrudRepository<Client, Integer> {
    
}
