/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.repository;

import com.reto5quadbike.reto5.model.Category;
import com.reto5quadbike.reto5.Interface.CategoryInterface;
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
public class CategoryRepositorio {
    
    @Autowired
    /**
     * Definición de la variable crud
     * Es de tipo ClientInterface donde se importa el crud repository
     */
    private CategoryInterface crud;
    /**
     * getAll()
     * Esta función retorna el metodo findAll() aplicado al crud repository
     * @return (List<Category>) crud.findAll()
     */
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    
    /**
     * getCategory(int id)
     * Esta función retorna la busqueda del id de manera personalizada, a partir del parámetro Integer id
     * @param id
     * @return crud.findById(id)
     */
    public Optional<Category> getCategory(int id){
        return crud.findById(id);
    }
    
    /**
     * save(Category category)
     * Esta función guarda información a partir del método save() del crud repository
     * @param category
     * @return crud.save(category)
     */
    public Category save(Category category){
        return crud.save(category);
    }
    
    /**
     * delete(Category category)
     * Esta función elimina información a partir del método delete() del crud repository
     * @param category 
     */
    public void delete(Category category){
       crud.delete(category);
    }
}
