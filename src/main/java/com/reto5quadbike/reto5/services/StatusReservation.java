/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.services;

/**
 * StatusReservation 
 * 
 * En esta clase mediante la anotación @Service, se indica que
 * se contendrá la lógica de negocio de la clase Reservation Será usada como la
 * capa de servicios
 *
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
public class StatusReservation {
    
    /**
     * Definición de variable completed
     * Tipo Integer, reservacion completada
     */
    private int completed;
    
    /**
     * Definición de variable canceller
     * Tipo Integer, reservacion cancelada
     */
    private int cancelled;
    
    /**
     * Método constructor de la clase StatusReservation
     * @param completed
     * @param cancelled 
     */
    public StatusReservation(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    
    /**
     * getCompleted()
     * Esta función retorna un entero con completado
     * @return completed
     */
    public int getCompleted() {
        return completed;
    }

    /**
     * setCompleted(int completed)
     * Esta función recibe un completado mediante un entero y actualiza la información del objeto
     * @param completed, the completed to set
     */
    public void setCompleted(int completed) {
        this.completed = completed;
    }

    /**
     * getCancelled()
     * Esta función retorna un entero con cancelado
     * @return completed
     */
    public int getCancelled() {
        return cancelled;
    }
    
    /**
     * setCancelled(int cancelled)
     * Esta función recibe un cancelado mediante un entero y actualiza la información del objeto
     * @param cancelled, the cancelled to set
     */
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
    
}
