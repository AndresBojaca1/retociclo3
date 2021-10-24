/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Controller;

import com.reto3Quadbike.Reto3.Model.Reservation;
import com.reto3Quadbike.Reto3.Services.ReservationServicios;
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
 * ReservationControladorWeb 
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ReservationControladorWeb {
    
    @Autowired
    /**
     * Definición de variable servicio
     * Tipo ClientServicios, permite llamar la capa de servicios
     */
    private ReservationServicios servicio;
    
    /**
     * getReservation()
     * 
     * Esta función con su mapeo correspondiente permite obtener toda la informacion de la clase
     * Reservation mediante un JSON
     * 
     * @return servicio.getAll()
     */
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return servicio.getAll();
    }
    
    /**
     * getReservation(@PathVariable("id") int reservationId) 
     * 
     * Esta función con su mapeo correspondiente permite obtener información correspondiente a un 
     * único reservationId de la clase Reservation mediante un JSON
     * 
     * @param reservationId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    
    /**
     * save(@RequestBody Reservation reservation)
     * 
     * Esta función con su mapeo correspondiente permite guardar nueva información en
     * la clase Reservation mediante una solicitud JSON
     * 
     * @param reservation
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return servicio.save(reservation);
    }
    
    /**
     * update(@RequestBody Reservation reservation)
     * 
     * Esta función con su mapeo correspondiente permite actualizar información existente
     * en la clase Reservation mediante una solicitud JSON
     * 
     * @param reservation
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return servicio.update(reservation);
    }
    
    /**
     * delete(@PathVariable("id") int reservationId)
     * 
     * Esta función con su mapeo correspondiente permite eliminar información a partir de un 
     * unico reservationId existente en la clase Reservation mediante una solicitud JSON
     * 
     * @param reservationId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
}
