/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Repository;

import com.reto3Quadbike.Reto3.Interface.MessageInterface;
import com.reto3Quadbike.Reto3.Model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * Esta clase implementa el repositorio mediante la anotación @Repository, se busca el encapsulamiento, almacenamiento, recuperación 
 * y busqueda que emula una colección de objetos.
 * 
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
@Repository
public class MessageRepositorio {
    
    @Autowired
    /**
     * Definición de la variable crud
     * Es de tipo ClientInterface donde se importa el crud repository
     */
    private MessageInterface crud;
    
    /**
     * getAll()
     * Esta función retorna el metodo findAll() aplicado al crud repository
     * @return (List<Message>) crud.findAll()
     */
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    
    /**
     * getMessage(int id)
     * Esta función retorna la busqueda del id de manera personalizada, a partir del parámetro Integer id
     * @param id
     * @return crud.findById(id)
     */
    public Optional<Message> getMessage(int id){
        return crud.findById(id);
    }
    
    /**
     * save(Message message)
     * Esta función guarda información a partir del método save() del crud repository
     * @param message
     * @return crud.save(message)
     */
    public Message save(Message message){
        return crud.save(message);
    }
    
    /**
     * delete(Message message)
     * Esta función elimina información a partir del método delete() del crud repository
     * @param message 
     */
    public void delete(Message message){
        crud.delete(message);
    }
}
