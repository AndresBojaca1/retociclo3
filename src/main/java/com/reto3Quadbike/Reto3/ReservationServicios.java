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
public class ReservationServicios {
    
    @Autowired
    private ReservationRepositorio metodoCrud;

    public List<Reservation> getAll(){
        return metodoCrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return metodoCrud.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation ()== null) {
            return metodoCrud.save(reservation);
        }else{
            Optional<Reservation> respuesta = metodoCrud.getReservation(reservation.getIdReservation());
            if (respuesta.isEmpty()) {
                return metodoCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> respuesta = metodoCrud.getReservation(reservation.getIdReservation());
            if(!respuesta.isEmpty()){

                if (reservation.getStartDate() != null) {
                    respuesta.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    respuesta.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    respuesta.get().setStatus(reservation.getStatus());
                }
                metodoCrud.save(respuesta.get());
                return respuesta.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean respuesta = getReservation(reservationId).map(reservation -> {
            metodoCrud.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
