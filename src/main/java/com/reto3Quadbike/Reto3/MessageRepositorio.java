/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andre
 */
@Repository
public class MessageRepositorio {
    
    @Autowired
    private MessageInterface crud;
    
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    public Optional<Message> getMessage(int id){
        return crud.findById(id);
    }

    public Message save(Message message){
        return crud.save(message);
    }
    public void delete(Message message){
        crud.delete(message);
    }
}
