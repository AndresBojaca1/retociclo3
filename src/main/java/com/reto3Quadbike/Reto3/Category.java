/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue
    
    //Elementos de la tabla category
    private Integer id;
    private String name;
    private String description;
    
    //Relacion uno a muchos -> Base de datos relacional
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Quadbike> quadbikes;
    
    //Creacion getter y setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Quadbike> getQuadbikes() {
        return quadbikes;
    }

    public void setQuadbikes(List<Quadbike> quadbikes) {
        this.quadbikes = quadbikes;
    }

    
}
