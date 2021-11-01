/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category Esta clase implementa FirstCode
 * Es un entity que se almacena con el nombre "category" en la base de datos 
 * Contiene los atributos y se maneja un autoincremento para id
 * 
 * Llave PK de client es id
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Definición de la variable id
     * Es un Integer que contiene el id de la categoría, es autoincremental
     */
    private Integer id;
    
    /**
     * Definición de la variable name
     * Es un String que hace referencia al nombre de la categoría
     */
    @Column(length = 45)    
    private String name;
    
    /**
     * Definición de la variable description
     * Es un String que contiene la descripción de la categoría, 
     */
    @Column(length = 250)
    private String description;

    /**
     * Definición de la variable quadbikes
     * Relación uno a muchos "quadbikes"
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Quadbike> quadbikes;

    //Creación getter y setter
    /**
     * getId()
     * Esta función retorna la id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setId(Integer id)
     * ESta función recibe un id y actualiza la información del objeto
     * @param id, the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getName()
     * Esta función retorna el nombre
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setName(String name)
     * ESta función recibe un nombre y actualiza la información del objeto
     * @param name, the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getDescription()
     * Esta función retorna la descripción
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription(String description)
     * ESta función recibe una descripción y actualiza la información del objeto
     * @param description, the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getQuadbikes()
     * Esta función retorna una lista de la clase cuatrimoto y sus atributos
     * @return quadbikes
     */
    public List<Quadbike> getQuadbikes() {
        return quadbikes;
    }

    /**
     * setQuadbikes(List<Quadbike> quadbikes)
     * ESta función recibe una lista con los atributos de la clase Quadbike y actualiza la información del objeto
     * @param quadbikes, the quadbikes to set
     */
    public void setQuadbikes(List<Quadbike> quadbikes) {
        this.quadbikes = quadbikes;
    }

}
