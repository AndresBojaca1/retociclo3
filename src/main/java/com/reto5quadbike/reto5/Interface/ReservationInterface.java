/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.Interface;

import com.reto5quadbike.reto5.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * ReservationInterface
 * Esta interface implementa el Repository que es manejado por JPA de la tabla y la clase Reservation
 * 
 * 
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author andre
 */
public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
    /**
     * 
     * @param status
     * @return 
     */
    public List<Reservation> findAllByStatus(String status);
    
    /**
     * 
     * @param dateone
     * @param datetwo
     * @return 
     */
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateone, Date datetwo);
    
    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
