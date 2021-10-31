/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message Esta clase implementa FirstCode, 
 * Es un entity que se almacena con el nombre "message" en la base de datos 
 * Contiene los atributos y se maneja un autoincremento para idMessage 
 * Llave PK de client es idMessage
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
@Entity
@Table(name = "message")

public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Elementos de mi tabla
    /**
     * Definición de la variable idMessage 
     * Es un Integer que contiene el id del mensaje, es autoincremental
     */
    private Integer idMessage;
    
    /**
     * Definición de la variable messageText 
     * Es un String que contiene el texto del mensaje
     */
    private String messageText;

    /**
     * Definición de la variable quadbike 
     * Relación muchos a uno "quadbikes"
     */
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Quadbike quadbike;

    /**
     * Definición de la variable client 
     * Relación muchos a uno "client"
     */
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;

    //Getters y Setters
    /**
     * getIdMessage()
     * Esta función retorna la idMessage
     * @return idMessage
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * setIdMessage(Integer idMessage)
     * Esta función recibe una id del mensaje y actualiza la información del objeto
     * @param idMessage, the idMessage to set
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * getMessageText()
     * Esta función retorna un texto con mensaje
     * @return messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * setMessageText(String messageText)
     * Esta función recibe un mensaje con texto y actualiza la información del objeto
     * @param messageText, the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * getQuadbike()
     * Esta funcion retorna la clase Quadbike y sus atributos
     * @return quadbike
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * setQuadbike(Quadbike quadbike)
     * Esta función recibe una clase quadbike y sus atributos  y actualiza la información del objeto
     * @param quadbike, the quadbike to set
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * getClient()
     * Esta función retorna el cliente y sus atributos
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * setClient(Client client)
     * Esta función recibe una clase client y sus atributos y actualiza la información del objeto
     * @param client, the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
