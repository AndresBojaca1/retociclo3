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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client Esta clase implementa FirstCode, 
 * Es un entity que se almacena con el nombre "client" en la base de datos 
 * Contiene los atributos y se maneja un autoincremento para idClient 
 * 
 * Llave PK de client es idClient
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Definición de la variable idClient 
     * Es un Integer que contiene el id del cliente, es autoincremental
     */
    private Integer idClient;
    
    /**
     * Definición de la variable email 
     * Es un String que contiene el email del cliente
     */
    private String email;
    
    /**
     * Definición de la variable password 
     * Es un String que contiene la contraseña del cliente
     */
    private String password;
    
    /**
     * Definición de la variable name 
     * Es un String que contiene el nombre del cliente
     */
    private String name;
    
    /**
     * Definición de la variable age 
     * Es un Integer que contiene la edad del cliente 
     */
    private Integer age;

    /**
     * Definición de la variable messages 
     * Relación uno a muchos "messages"
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Message> messages;

    /**
     * Definición de la variable reservations 
     * Relación uno a muchos "reservations"
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservation> reservations;

    
    //Getters and Setters
    /**
     * getIdClient()
     * Esta función retorna la idClient
     * @return idClient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * setIdClient(Integer idClient)
     * Esta función recibe una id de cliente y actualiza la información del objeto
     * @param idClient, the idClient to set
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * getEmail()
     * Esta función retorna el email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail(String email)
     * Esta función recibe un email y actualiza la información del objeto
     * @param email, the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getPassword()
     * Esta función retorna la password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword(String password)
     * Esta función recibe una password y actualiza la información del objeto
     * @param password, the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Esta función recibe un name y actualiza la información del objeto
     * @param name, the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getAge()
     * Esta función retorna la edad
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * setAge(Integer age)
     * Esta función recibe una edad y actualiza la información del objeto
     * @param age, the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * getMessages()
     * Esta función retorna una lista de mensajes y sus atributos
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * setMessages(List<Message> messages)
     * Esta función recibe una lista con mensajes y actualiza la información del objeto
     * @param messages, the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * getReservations()
     * Esta función retorna una lista de reservaciones y sus atributos
     * @return reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * setReservations(List<Reservation> reservations)
     * Esta función recibe una lista de reservaciones y actualiza la información del objeto
     * @param reservations, the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
