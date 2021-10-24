/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Repository;

import com.reto3Quadbike.Reto3.Model.Client;
import com.reto3Quadbike.Reto3.Interface.ClientInterface;
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
public class ClientRepositorio {
    
    @Autowired
    /**
     * Definición de la variable crud
     * Es de tipo ClientInterface donde se importa el crud repository
     */
    private ClientInterface crud;
    
    /**
     * getAll()
     * Esta función retorna el metodo findAll() aplicado al crud repository
     * @return (List<Client>) crud.findAll()
     */
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    
    /**
     * getClient(int id)
     * Esta función retorna la busqueda del id de manera personalizada, a partir del parámetro Integer id
     * @param id
     * @return crud.findById(id)
     */
    public Optional<Client> getClient(int id){
        return crud.findById(id);
    }
    
    /**
     * save(Client client)
     * Esta función guarda información a partir del método save() del crud repository
     * @param client
     * @return crud.save(client)
     */
    public Client save(Client client){
        return crud.save(client);
    }
    
    /**
     * delete(Client client)
     * Esta función elimina información a partir del método delete() del crud repository
     * @param client 
     */
    public void delete(Client client){
        crud.delete(client);
    }
}
