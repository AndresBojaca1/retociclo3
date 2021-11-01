/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5quadbike.reto5.services;

import com.reto5quadbike.reto5.repository.ReservationRepositorio;
import com.reto5quadbike.reto5.model.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReservationServicios 
 * 
 * En esta clase mediante la anotación @Service, se indica que
 * se contendrá la lógica de negocio de la clase Reservation Será usada como la
 * capa de servicios
 *
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
@Service
public class ReservationServicios {

    @Autowired
    /**
     * getAll() Esta función retorna el método getAll() del repositorio -> GET -
     * READ
     *
     * @return
     */
    private ReservationRepositorio metodoCrud;

    /**
     * getAll() Esta función retorna el método getAll() del repositorio
     *
     * @return
     */
    public List<Reservation> getAll() {
        return metodoCrud.getAll();
    }

    /**
     * getReservation(int reservationId) Esta función obtiene la Id de
     * reservaciones -> GET - READ
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return metodoCrud.getReservation(reservationId);
    }

    /**
     * save(Reservation reservation) Esta función guarda información de la clase
     * Reservation y sus atributos -> POST - CREATE
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodoCrud.save(reservation);
        } else {
            Optional<Reservation> respuesta = metodoCrud.getReservation(reservation.getIdReservation());
            if (respuesta.isEmpty()) {
                return metodoCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * update(Reservation reservation) Esta función actualiza información con un
     * id de reservación existente -> PUT - UPDATE
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> respuesta = metodoCrud.getReservation(reservation.getIdReservation());
            if (!respuesta.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    respuesta.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    respuesta.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    respuesta.get().setStatus(reservation.getStatus());
                }
                if (reservation.getScore() != null) {
                    respuesta.get().setScore(reservation.getScore());
                }
                metodoCrud.save(respuesta.get());
                return respuesta.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * deleteReservation(int reservationId) Esta función elimina a partir de id
     * de reservación -> DELETE - DELETE
     *
     * @param reservationId
     * @return
     */
    public boolean deleteReservation(int reservationId) {
        Boolean respuesta = getReservation(reservationId).map(reservation -> {
            metodoCrud.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }
    
    /**
     * getRepStatusRes()
     * Esta función permite obtener un estado de la reservacion, como cancelada o completada. 
     * @return 
     */
    public StatusReservation getRepStatusRes() {
        List<Reservation>completed = metodoCrud.ReservationStatus("completed");
        List<Reservation>cancelled = metodoCrud.ReservationStatus("cancelled");
        return new StatusReservation(completed.size(),cancelled.size());
    }
    
    /**
     * serviceReportTime (String datoA, String datoB)
     * Esta función permite dar formato al tiempo e impedir que una fecha antigua se cruce con una fecha actual para evitar esto se usa un try catch.
     * @param datoA
     * @param datoB
     * @return 
     */
    public List<Reservation> serviceReportTime (String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date dateOne = new Date();
        Date dateTwo = new Date();
        
        try{
            dateOne = parser.parse(datoA);
            dateTwo = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(dateOne.before(dateTwo)) {
            return metodoCrud.ReservationTimeRepository(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
    
    /**
     * serviceClientReport()
     * Esta funcion utiliza el metodo para obtener clientes del repositorio
     * @return 
     */
    public List<ClientCounter> serviceClientReport() {
        return metodoCrud.getClientRepository();
    }
}
