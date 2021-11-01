/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.services;

import com.reto5quadbike.reto5.model.Category;
import com.reto5quadbike.reto5.repository.CategoryRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoryServicios 
 * 
 * En esta clase mediante la anotación @Service, se indica que
 * se contendrá la lógica de negocio de la clase Category Será usada como la
 * capa de servicios
 *
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
@Service
public class CategoryServicios {

    @Autowired
    /**
     * Definición de la variable metodoCrud Es de tipo CategoryRepositorio e
     * implementa metodos CRUD
     */
    private CategoryRepositorio metodoCrud;

    /**
     * getAll() Esta función retorna el método getAll() del repositorio -> GET -
     * READ
     *
     * @return
     */
    public List<Category> getAll() {
        return metodoCrud.getAll();
    }

    /**
     * getCategory(int categoryId) Esta funcion obtiene la Id de la categoría ->
     * GET - READ
     *
     * @param categoryId
     * @return
     */
    public Optional<Category> getCategory(int categoryId) {
        return metodoCrud.getCategory(categoryId);
    }

    /**
     * save(Category category) Esta función guarda información de la clase
     * Category y sus atributos -> POST - CREATE
     *
     * @param category
     * @return
     */
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

    /**
     * update(Category category) Esta función actualiza información con un id de
     * categoría existente -> PUT - UPDATE
     *
     * @param category
     * @return
     */
    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> respuesta = metodoCrud.getCategory(category.getId());
            if (!respuesta.isEmpty()) {
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

    /**
     * deleteCategory(int categoryId) Esta función elimina a partir de id ->
     * DELETE - DELETE
     *
     * @param categoryId
     * @return
     */
    public boolean deleteCategory(int categoryId) {
        Boolean respuesta = getCategory(categoryId).map(category -> {
            metodoCrud.delete(category);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
