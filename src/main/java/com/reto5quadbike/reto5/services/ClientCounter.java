/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.services;

import com.reto5quadbike.reto5.model.Client;



/**
 * 
 * Esta clase genera los metodos para llevar a cabo un contador de clientes posteriormente usad como metodo en 
 * el repositorio de Reservaciones
 * 
 *
 * @since 01/11/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
public class ClientCounter {
    private Long total;
    private Client client;
    
    /**
     * Metodo constructor de la clase clientCounter
     * @param total
     * @param client 
     */
    public ClientCounter(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    /**
     * 
     * @return 
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 
     * @param total 
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 
     * @return 
     */
    public Client getClient() {
        return client;
    }

    /**
     * 
     * @param client 
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
