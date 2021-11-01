/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.controller;

import com.reto5quadbike.reto5.model.Category;
import com.reto5quadbike.reto5.services.CategoryServicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoryControladorWeb 
 * 
 * En esta clase mediante la anotación @RestController para simplificar la creacion de servicios web RESTful,
 * funciona como componente administrado por Spring para permitir el manejo de soluciones HTTP usando API REST
 * Permite la gestion de lógica de negocio mediante el envio de solicitudes HTTP
 * 
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class CategoryControladorWeb {

    @Autowired
    /**
     * Definición de variable servicio
     * Tipo ClientServicios, permite llamar la capa de servicios
     */
    private CategoryServicios servicio;
    
    /**
     * getCategory()
     * 
     * Esta función con su mapeo correspondiente permite obtener toda la informacion de la clase 
     * Category mediante un JSON
     * 
     * @return servicio.getAll()
     */
    @GetMapping("/all")
    public List<Category> getCategory(){
        return servicio.getAll();
    }

    /**
     * getCategory(@PathVariable("id") int categoryId)
     * 
     * Esta función con su mapeo correspondiente permite obtener información correspondiente a un 
     * único categoryId de la clase Category mediante un JSON
     * 
     * @param categoryId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId) {
        return servicio.getCategory(categoryId);
    }

    /**
     * save(@RequestBody Category category)
     * 
     * Esta función con su mapeo correspondiente permite guardar nueva información en
     * la clase Category mediante una solicitud JSON
     * 
     * @param category
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return servicio.save(category);
    }
    
    /**
     * update(@RequestBody Category category)
     * 
     * Esta función con su mapeo correspondiente permite actualizar información existente
     * en la clase Category mediante una solicitud JSON
     * 
     * @param category
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return servicio.update(category);
    }
    
    /**
     * delete(@PathVariable("id") int categoryId)
     * 
     * Esta función con su mapeo correspondiente permite eliminar información a partir de un 
     * unico categoryId existente en la clase Category mediante una solicitud JSON
     * 
     * @param categoryId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return servicio.deleteCategory(categoryId);
    }
}
