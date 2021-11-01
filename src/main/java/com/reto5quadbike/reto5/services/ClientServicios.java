/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.services;

import com.reto5quadbike.reto5.model.Client;
import com.reto5quadbike.reto5.repository.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientServicios 
 * 
 * En esta clase mediante la anotación @Service, se indica que
 * se contendrá la lógica de negocio de la clase Client Será usada como la capa
 * de servicios
 *
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
@Service
public class ClientServicios {

    @Autowired
    /**
     * Definición de la variable metodoCrud Es de tipo ClientRepositorio e
     * implementa metodos CRUD
     */
    private ClientRepositorio metodoCrud;

    /**
     * getAll() Esta función retorna el método getAll() del repositorio -> GET -
     * READ
     *
     * @return
     */
    public List<Client> getAll() {
        return metodoCrud.getAll();
    }

    /**
     * getClient(int clientId) Esta funcion obtiene la Id del cliente -> GET -
     * READ
     *
     * @param clientId
     * @return
     */
    public Optional<Client> getClient(int clientId) {
        return metodoCrud.getClient(clientId);
    }

    /**
     * save(Client client) Esta función guarda información de la clase Client y
     * sus atributos -> POST - CREATE
     *
     * @param client
     * @return
     */
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return metodoCrud.save(client);
        } else {
            Optional<Client> respuesta = metodoCrud.getClient(client.getIdClient());
            if (respuesta.isEmpty()) {
                return metodoCrud.save(client);
            } else {
                return client;
            }
        }
    }

    /**
     * update(Client client) Esta función actualiza información con un id de
     * cliente existente -> PUT - UPDATE
     *
     * @param client
     * @return
     */
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> respuesta = metodoCrud.getClient(client.getIdClient());
            if (!respuesta.isEmpty()) {
                if (client.getName() != null) {
                    respuesta.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    respuesta.get().setEmail(client.getEmail());
                }
                if (client.getAge() != null) {
                    respuesta.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    respuesta.get().setPassword(client.getPassword());
                }
                metodoCrud.save(respuesta.get());
                return respuesta.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    /**
     * deleteClient(int clientId) Esta función elimina a partir de id de
     * cliente-> DELETE - DELETE
     *
     * @param clientId
     * @return
     */
    public boolean deleteClient(int clientId) {
        Boolean respuesta = getClient(clientId).map(client -> {
            metodoCrud.delete(client);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
