/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Controller;

import com.reto3Quadbike.Reto3.Model.Message;
import com.reto3Quadbike.Reto3.Services.MessageServicios;
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
 * MessageControladorWeb 
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class MessageControladorWeb {
    
    @Autowired
    /**
     * Definición de variable servicio
     * Tipo ClientServicios, permite llamar la capa de servicios
     */
    private MessageServicios servicio;
    
    /**
     * getMessages()
     * 
     * Esta función con su mapeo correspondiente permite obtener toda la informacion de la clase
     * Message mediante un JSON
     * 
     * @return servicio.getAll()
     */
    @GetMapping("/all")
    public List<Message> getMessages(){
        return servicio.getAll();
    }

    /**
     * getMessage(@PathVariable("id") int messageId)
     * 
     * Esta función con su mapeo correspondiente permite obtener información correspondiente a un 
     * único messageId de la clase Message mediante un JSON
     * 
     * @param messageId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        return servicio.getMessage(messageId);
    }

    /**
     * save(@RequestBody Message message)
     * 
     * Esta función con su mapeo correspondiente permite guardar nueva información en
     * la clase Message mediante una solicitud JSON
     * 
     * @param message
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return servicio.save(message);
    }
    
    /**
     * update(@RequestBody Message message)
     * 
     * Esta función con su mapeo correspondiente permite actualizar información existente
     * en la clase Message mediante una solicitud JSON
     * 
     * @param message
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return servicio.update(message);
    }

    /**
     * delete(@PathVariable("id") int messageId)
     * 
     * Esta función con su mapeo correspondiente permite eliminar información a partir de un 
     * unico messageId existente en la clase Message mediante una solicitud JSON
     * 
     * @param messageId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return servicio.deleteMessage(messageId);
    }
}
