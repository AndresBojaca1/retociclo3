/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Controller;

import com.reto3Quadbike.Reto3.Model.Quadbike;
import com.reto3Quadbike.Reto3.Services.QuadbikeServicios;
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
 * QuadbikeControladorWeb 
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
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}) //Permite acceso CORS de Oracle

public class QuadbikeControladorWeb {
    
    @Autowired
    /**
     * Definición de variable servicio
     * Tipo ClientServicios, permite llamar la capa de servicios
     */
    private QuadbikeServicios servicio;
    
    /**
     * getQuadbike()
     * 
     * Esta función con su mapeo correspondiente permite obtener toda la informacion de la clase
     * Quadbike mediante un JSON
     * 
     * @return servicio.getAll()
     */
    @GetMapping("/all")
    public List<Quadbike> getQuadbike(){
        return servicio.getAll();
    }
    
    /**
     * getQuadbike(@PathVariable("id") int quadbikeId)
     * 
     * Esta función con su mapeo correspondiente permite obtener información correspondiente a un 
     * único quadbikeId de la clase Quadbike mediante un JSON
     * 
     * @param quadbikeId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int quadbikeId) {
        return servicio.getQuadbike(quadbikeId);
    }
    
    /**
     * save(@RequestBody Quadbike quadbike)
     * 
     * Esta función con su mapeo correspondiente permite guardar nueva información en
     * la clase Quadbike mediante una solicitud JSON
     * 
     * @param quadbike
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike quadbike) {
        return servicio.save(quadbike);
    }
    
    /**
     * update(@RequestBody Quadbike quadbike)
     * 
     * Esta función con su mapeo correspondiente permite actualizar información existente
     * en la clase Quadbike mediante una solicitud JSON
     * 
     * @param quadbike
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike) {
        return servicio.update(quadbike);
    }
    
    /**
     * delete(@PathVariable("id") int quadbikeId)
     * 
     * Esta función con su mapeo correspondiente permite eliminar información a partir de un 
     * unico quadbikeId existente en la clase Quadbike mediante una solicitud JSON
     * 
     * @param quadbikeId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int quadbikeId) {
        return servicio.deleteQuadbike(quadbikeId);
    }     
}
