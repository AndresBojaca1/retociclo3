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
@Table(name = "messages")

public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Elementos de mi tabla
    private Integer idMessage;
    private String messageText;
    
    //Relacion muchos a uno 
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Quadbike quadbikes;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
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

    public Quadbike getQuadbikes() {
        return quadbikes;
    }

    public void setQuadbikes(Quadbike quadbikes) {
        this.quadbikes = quadbikes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
