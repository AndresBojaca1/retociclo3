/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Interface;

import com.reto3Quadbike.Reto3.Model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * MessageInterface
 * Esta interface implementa el Repository que es manejado por JPA de la tabla y la clase Message
 * 
 * 
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
public interface MessageInterface extends CrudRepository<Message, Integer> {
    
}
