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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "quadbikes")
public class Quadbike implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Elementos obtenidos del JSON de historia de usuario. -> Seran los elementos de mi tabla
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    
    //Relacion muchos  a uno
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("quadbikes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "quadbikes")
    @JsonIgnoreProperties({"quadbikes", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "quadbikes")
    @JsonIgnoreProperties({"quadbikes", "client"})
    private List<Reservation> reservations;
    
    //CREACION GETTER AND SETTER DE LOS ATRIBUTOS

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
}
