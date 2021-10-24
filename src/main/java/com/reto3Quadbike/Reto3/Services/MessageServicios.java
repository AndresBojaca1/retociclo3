/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Services;

import com.reto3Quadbike.Reto3.Model.Message;
import com.reto3Quadbike.Reto3.Repository.MessageRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MessageServicios 
 * 
 * En esta clase mediante la anotación @Service, se indica que
 * se contendrá la lógica de negocio de la clase Message Será usada como la capa
 * de servicios
 *
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
@Service
public class MessageServicios {

    @Autowired
    /**
     * Definición de la variable metodoCrud Es de tipo MessageRepositorio e
     * implementa metodos CRUD
     */
    private MessageRepositorio metodoCrud;

    /**
     * getAll() Esta función retorna el método getAll() del repositorio -> GET -
     * READ
     *
     * @return
     */
    public List<Message> getAll() {
        return metodoCrud.getAll();
    }

    /**
     * getMessage(int messageId) Esta funcion obtiene la Id del mensaje -> GET -
     * READ
     *
     * @param messageId
     * @return
     */
    public Optional<Message> getMessage(int messageId) {
        return metodoCrud.getMessage(messageId);
    }

    /**
     * save(Message message) Esta función guarda información de la clase Message
     * y sus atributos -> POST - CREATE
     *
     * @param message
     * @return
     */
    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return metodoCrud.save(message);
        } else {
            Optional<Message> respuesta = metodoCrud.getMessage(message.getIdMessage());
            if (respuesta.isEmpty()) {
                return metodoCrud.save(message);
            } else {
                return message;
            }
        }
    }

    /**
     * update(Message message) Esta función actualiza información con un id de
     * mensaje existente -> PUT - UPDATE
     *
     * @param message
     * @return
     */
    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> respuesta = metodoCrud.getMessage(message.getIdMessage());
            if (!respuesta.isEmpty()) {
                if (message.getMessageText() != null) {
                    respuesta.get().setMessageText(message.getMessageText());
                }
                metodoCrud.save(respuesta.get());
                return respuesta.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    /**
     * deleteMessage(int messageId) Esta función elimina a partir de id de
     * mensaje-> DELETE - DELETE
     *
     * @param messageId
     * @return
     */
    public boolean deleteMessage(int messageId) {
        Boolean respuesta = getMessage(messageId).map(message -> {
            metodoCrud.delete(message);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
