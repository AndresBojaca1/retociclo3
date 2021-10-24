/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Repository;

import com.reto3Quadbike.Reto3.Interface.ReservationInterface;
import com.reto3Quadbike.Reto3.Model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * Esta clase implementa el repositorio mediante la anotación @Repository, se busca el encapsulamiento, almacenamiento, recuperación 
 * y busqueda que emula una colección de objetos.
 * 
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
@Repository
public class ReservationRepositorio {
    
    @Autowired
    /**
     * Definición de la variable crud
     * Es de tipo ClientInterface donde se importa el crud repository
     */
    private ReservationInterface crud;
    
    /**
     * getAll()
     * Esta función retorna el metodo findAll() aplicado al crud repository
     * @return (List<Reservation>) crud.findAll()
     */
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    
    /**
     * getReservation(int id)
     * Esta función retorna la busqueda del id de manera personalizada, a partir del parámetro Integer id
     * @param id
     * @return crud.findById(id)
     */
    public Optional<Reservation> getReservation(int id){
        return crud.findById(id);
    }
    
    /**
     * save(Reservation reservation)
     * Esta función guarda información a partir del método save() del crud repository
     * @param reservation
     * @return crud.savereservationXXXX)
     */
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
    
    /**
     * delete(Reservation reservation)
     * Esta función elimina información a partir del método delete() del crud repository
     * @param reservation 
     */
    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
}
