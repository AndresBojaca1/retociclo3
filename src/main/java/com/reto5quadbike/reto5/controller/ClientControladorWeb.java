/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.controller;

import com.reto5quadbike.reto5.model.Client;
import com.reto5quadbike.reto5.services.ClientServicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientControladorWeb 
 * 
 * En esta clase mediante la anotación @RestController para simplificar la creacion de servicios web RESTful,
 * funciona como componente administrado por Spring para permitir el manejo de soluciones HTTP usando API REST
 * Permite la gestion de lógica de negocio mediante el envio de solicitudes HTTP
 * 
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ClientControladorWeb {
    
    @Autowired
    /**
     * Definición de variable servicio
     * Tipo ClientServicios, permite llamar la capa de servicios
     */
    private ClientServicios servicio;
  
    /**
     * getClient()
     * 
     * Esta función con su mapeo correspondiente permite obtener toda la informacion de la clase
     * Client mediante un JSON
     * 
     * @return servicio.getAll()
     */
    @GetMapping("/all")
    public List<Client> getClient(){
        return servicio.getAll();
    }
    
    /**
     * getClient(@PathVariable("id") int clientId)
     * 
     * Esta función con su mapeo correspondiente permite obtener información correspondiente a un 
     * único clientId de la clase Client mediante un JSON
     * 
     * @param clientId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId) {
        return servicio.getClient(clientId);
    }

    /**
     * save(@RequestBody Client client)
     * 
     * Esta función con su mapeo correspondiente permite guardar nueva información en
     * la clase Client mediante una solicitud JSON
     * 
     * @param client
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return servicio.save(client);
    }
    
    /**
     * update(@RequestBody Client client) 
     * 
     * Esta función con su mapeo correspondiente permite actualizar información existente
     * en la clase Client mediante una solicitud JSON
     * 
     * @param client
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return servicio.update(client);
    }

    /**
     * delete(@PathVariable("id") int clientId)
     * 
     * Esta función con su mapeo correspondiente permite eliminar información a partir de un 
     * unico clientId existente en la clase Client mediante una solicitud JSON
     * 
     * @param clientId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return servicio.deleteClient(clientId);
    }
}
