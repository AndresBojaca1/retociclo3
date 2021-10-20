/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author andre
 */

@Entity
@Table(name = "message")

public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Elementos de mi tabla
    private Integer idMessage;
    private String messageText;
    
    //Relacion muchos a uno 
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"message", "client", "reservation"})
    private Quadbike quadbike;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"message", "client", "reservation"})
    private Client client;

    //Getters y Setters
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Quadbike getQuadbike() {
        return quadbike;
    }

    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
