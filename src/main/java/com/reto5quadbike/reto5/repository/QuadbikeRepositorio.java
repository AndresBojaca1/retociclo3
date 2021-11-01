/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.repository;

import com.reto5quadbike.reto5.Interface.QuadbikeInterface;
import com.reto5quadbike.reto5.model.Quadbike;
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
public class QuadbikeRepositorio {

    @Autowired
    /**
     * Definición de la variable crud
     * Es de tipo ClientInterface donde se importa el crud repository
     */
    private QuadbikeInterface crud;
    
    /**
     * getAll()
     * Esta función retorna el metodo findAll() aplicado al crud repository
     * @return (List<Quadbike>) crud.findAll()
     */
    public List<Quadbike> getAll() {
        return (List<Quadbike>) crud.findAll();
    }
    
    /**
     * getQuadbike(int id)
     * Esta función retorna la busqueda del id de manera personalizada, a partir del parámetro Integer id
     * @param id
     * @return crud.findById(id)
     */
    public Optional<Quadbike> getQuadbike(int id) {
        return crud.findById(id);
    }
    
    /**
     * save(Quadbike quadbike)
     * Esta función guarda información a partir del método save() del crud repository
     * @param quadbike
     * @return crud.save(quadbike)
     */
    public Quadbike save(Quadbike quadbike) {
        return crud.save(quadbike);
    }

    /**
     * delete(Quadbike quadbike)
     * Esta función elimina información a partir del método delete() del crud repository
     * @param quadbike 
     */
    public void delete(Quadbike quadbike) {
        crud.delete(quadbike);
    }
}
