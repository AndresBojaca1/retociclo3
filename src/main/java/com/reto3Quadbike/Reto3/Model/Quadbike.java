/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Quadbike Esta clase implementa FirstCode, 
 * Es un entity que se almacena con el nombre "quadbike" en la base de datos 
 * Contiene los atributos y se maneja un autoincremento para id 
 * 
 * Llave PK de client es id
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
@Entity
@Table(name = "quadbike")
public class Quadbike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Elementos obtenidos del JSON de historia de usuario. -> Seran los elementos de mi tabla
    /**
     * Definición de la variable id 
     * Es un Integer que contiene el id de la cuatrimoto, es autoincremental
     */
    private Integer id;
    
    /**
     * Definición de la variable name
     * Es un String que contiene el nombre de la cuatrimoto
     */
    @Column(length = 45)
    private String name;
    
    /**
     * Definición de la variable brand 
     * Es un String que contiene la marca de la cuatrimoto
     */
    @Column(length = 45)
    private String brand;
    
    /**
     * Definición de la variable year 
     * Es un Integer que contiene el año de modelo de la cuatrimoto
     */@Column(length = 4)
    private Integer year;
    
    /**
     * Definición de la variable description 
     * Es un String que contiene el texto de descripción de la cuatrimoto
     */
     @Column(length = 250)
    private String description;

    /**
     * Definición de la variable category
     * Relacion muchos a uno Category
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("quadbikes")
    private Category category;

    /**
     * Definición de la variable messages
     * Relacion uno a muchos Messages
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;

    /**
     * Definición de la variable reservations
     * Relacion uno a muchos Reservations
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "message"}) // ----- > Antes de message era Client : REVISAR 28/10/21
    private List<Reservation> reservations;

    //CREACION GETTER AND SETTER DE LOS ATRIBUTOS
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
     * Esta función recibe una id y actualiza la información del objeto
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
     * Esta función recibe un nombre y actualiza la información del objeto
     * @param name, the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getBrand()
     * Esta función retorna la marca
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * setBrand(String brand)
     * Esta función recibe una marca y actualiza la información del objeto
     * @param brand, the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * getYear()
     * Esta funcion retorna el año
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * setYear(Integer year)
     * Esta función recibe un año y actualiza la información del objeto
     * @param year, the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
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
     * Esta función recibe una descripción y actualiza la información del objeto
     * @param description, the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getCategory()
     * Esta función retorna la Categoría
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setCategory(Category category)
     * Esta función recibe una Categoría y actualiza la informacion del objeto
     * @param category, the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * getMessages()
     * Esta funcion retorna la lista con los atributos de la clase Message
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * setMessages(List<Message> messages)
     * Esta función recibe una lista con los atributos de la clase Message y actualiza la informacion del objeto
     * @param messages, the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * getReservations()
     * Esta funcion retorna la lista con los atributos de la clase Reservation
     * @return reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * setReservations(List<Reservation> reservations)
     * Esta función recibe una lista con los atributos de la clase Reservation y actualiza la informacion del objeto
     * @param reservations, the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
