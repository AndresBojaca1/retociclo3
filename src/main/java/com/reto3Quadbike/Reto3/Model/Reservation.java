/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Reservation Esta clase implementa FirstCode, 
 * Es un entity que se almacena con el nombre "reservation" en la base de datos 
 * Contiene los atributos y se maneja un autoincremento para idReservation
 * 
 * Llave PK de client es idReservation
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
@Entity
@Table(name = "reservation")

public class Reservation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Elementos JSON
    /**
     * Definición de la variable idReservation 
     * Es un Integer que contiene el id de la reservación, es autoincremental
     */
    private Integer idReservation;
    /**
     * Definición de la variable startDate 
     * Es un Date que contiene la fecha de inicio de la reservación de la cuatrimoto
     */
    private Date startDate;
    /**
     * Definición de la variable devolutionDate 
     * Es un Date que contiene la fecha final de la reservación de la cuatrimoto
     */
    private Date devolutionDate;
    /**
     * Definición de la variable status 
     * Es un String que contiene el estado de la cracion de reservacion de la cuatrimoto
     */
    private String status = "created";

    /**
     * Definición de la variable quadbike 
     * Relacion muchos a uno quadbike
     */
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Quadbike quadbike;

    /**
     * Definición de la variable client 
     * Relacion muchos a uno client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
    
    /**
     * Definición de la variable score 
     * Es un String que contiene el score de la reservación
     */
    private String score;

    //Getters and Setters  
    /**
     * getIdReservation()
     * Esta función retorna la id de la reservación
     * @return XXX
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * setIdReservation(Integer idReservation)
     * Esta función recibe una id de reservación y actualiza la información del objeto
     * @param idReservation, the idReservation to set
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * getStartDate(
     * Esta función retorna la fecha de inicio de reservación
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * setStartDate(Date startDate)
     * Esta función recibe una fecha de inicio de reservación y actualiza la información del objeto
     * @param startDate, the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * getDevolutionDate()
     * Esta función retorna la fecha de devolución
     * @return devolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * setDevolutionDate(Date devolutionDate)
     * Esta función recibe una fecha de devolución y actualiza la información del objeto
     * @param devolutionDate, the devolutionDate to set
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * getStatus()
     * Esta función retorna el estado de la reservación
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * setStatus(String status)
     * Esta función recibe el estado de la reservación y actualiza la información del objeto
     * @param status, the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * getQuadbike()
     * Esta función retorna los atributos de la clase Quadbike
     * @return quadbike
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * setQuadbike(Quadbike quadbike)
     * Esta función recibe los atributos de la clase Quadbike y actualiza la información del objeto
     * @param quadbike, the quadbike to set
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * getClient()
     * Esta función retorna los atributos de la clase Client
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * setClient(Client client)
     * Esta función recibe los atributos de la clase Client actualiza la información del objeto
     * @param client, the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * getScore()
     * Esta funcion retorna la calificación
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * setScore(String score)
     * Esta función recibe una calificación y actualiza la información del objeto
     * @param score, the score to set
     */
    public void setScore(String score) {
        this.score = score;
    }
}
