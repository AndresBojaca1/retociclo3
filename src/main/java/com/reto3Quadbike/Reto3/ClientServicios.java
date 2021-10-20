/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class ClientServicios {
    
    @Autowired
    private ClientRepositorio metodoCrud;
    

    public List<Client> getAll() {
        return metodoCrud.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return metodoCrud.getClient(clientId);
    }

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

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> respuesta = metodoCrud.getClient(client.getIdClient());
            if (!respuesta.isEmpty()) {
                if (client.getName() != null) {
                    respuesta.get().setName(client.getName());
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

    public boolean deleteClient(int clientId) {
        Boolean respuesta = getClient(clientId).map(client -> {
            metodoCrud.delete(client);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
