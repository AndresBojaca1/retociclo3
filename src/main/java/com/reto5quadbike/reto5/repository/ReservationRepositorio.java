/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.repository;

import com.reto5quadbike.reto5.services.ClientCounter;
import com.reto5quadbike.reto5.Interface.ReservationInterface;
import com.reto5quadbike.reto5.model.Client;
import com.reto5quadbike.reto5.model.Reservation;
import java.util.ArrayList;
import java.util.Date;
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
    
    /**
     * ReservationStatus(String status)
     * Esta función permite obtener el estado de la reservación
     * @param status
     * @return 
     */
    public List<Reservation> ReservationStatus(String status) {
        return crud.findAllByStatus(status);
    }
    
    /**
     * ReservationTimeRepository(Date date1, Date date2)
     * Esta función permite determinar la lista de reservaciones entre una fecha (date1) y otra fecha (date2)
     * @param date1
     * @param date2
     * @return 
     */
    public List<Reservation> ReservationTimeRepository(Date date1, Date date2) {
        return crud.findAllByStartDateAfterAndStartDateBefore(date1, date2);
    }
    
    /**
     * getClientRepository()
 Esta función permite generar un modelo de ClientCounter mediante el uso de un for para determinar la cantidad total
 de clientes.
     * @return 
     */
    public List<ClientCounter> getClientRepository() {
        List<ClientCounter> res = new ArrayList<>();
        List<Object[]> report = crud.countTotalReservationsByClient();
        
        for (int i = 0; i < report.size(); i++) {
            res.add(new ClientCounter((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return res;
    }
}
