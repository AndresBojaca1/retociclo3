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
public class MessageServicios {
    
    @Autowired
    private MessageRepositorio metodoCrud;

    public List<Message> getAll(){
        return metodoCrud.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return metodoCrud.getMessage(messageId);
    }

    public Message save(Message message){
        if (message.getIdMessage() == null){
            return metodoCrud.save(message);
        }else{
            Optional<Message> respuesta= metodoCrud.getMessage(message.getIdMessage());
            if (respuesta.isEmpty()) {
                return metodoCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if (message.getIdMessage() != null) {
            Optional<Message> respuesta = metodoCrud.getMessage(message.getIdMessage());
            if(!respuesta.isEmpty()){
                if (message.getMessageText() != null) {
                    respuesta.get().setMessageText(message.getMessageText());
                }
                metodoCrud.save(respuesta.get());
                return respuesta.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean respuesta = getMessage(messageId).map(message -> {
            metodoCrud.delete(message);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
