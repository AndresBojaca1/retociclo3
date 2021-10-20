/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class CategoryServicios {
    
    @Autowired
    private CategoryRepositorio metodoCrud;

    public List<Category> getAll() {
        return metodoCrud.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return metodoCrud.getCategory(categoryId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return metodoCrud.save(category);
        } else {
            Optional<Category> respuesta = metodoCrud.getCategory(category.getId());
            if (respuesta.isEmpty()) {
                return metodoCrud.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId() != null){
            Optional<Category> respuesta = metodoCrud.getCategory(category.getId());
            if(!respuesta.isEmpty()){
                if (category.getDescription() != null) {
                    respuesta.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    respuesta.get().setName(category.getName());
                }
                return metodoCrud.save(respuesta.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int categoryId){
        Boolean respuesta = getCategory(categoryId).map(category -> {
            metodoCrud.delete(category);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
