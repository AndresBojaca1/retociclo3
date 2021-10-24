/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3Quadbike.Reto3.Services;

import com.reto3Quadbike.Reto3.Model.Quadbike;
import com.reto3Quadbike.Reto3.Repository.QuadbikeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * QuadbikeServicios 
 * 
 * En esta clase mediante la anotación @Service, se indica que
 * se contendrá la lógica de negocio de la clase Quadbike Será usada como la
 * capa de servicios
 *
 *
 * @since 23/10/2021
 * @version 0.0.1 - SNAPSHOT
 * @author Andres Bojaca
 */
@Service
public class QuadbikeServicios {

    @Autowired
    /**
     * getAll() Esta función retorna el método getAll() del repositorio -> GET -
     * READ
     *
     * @return
     */
    private QuadbikeRepositorio metodoCrud;

    /**
     * getAll() Esta función retorna el método getAll() del repositorio
     *
     * @return
     */
    public List<Quadbike> getAll() {
        return metodoCrud.getAll();
    }

    /**
     * getQuadbike(int quadbikeId) Esta funcion obtiene la Id de la cuatrimoto
     * -> GET - READ
     *
     * @param quadbikeId
     * @return
     */
    public Optional<Quadbike> getQuadbike(int quadbikeId) {
        return metodoCrud.getQuadbike(quadbikeId);
    }

    /**
     * save(Quadbike quadbike) Esta función guarda información de la clase
     * Quadbike y sus atributos -> POST - CREATE
     *
     * @param quadbike
     * @return
     */
    public Quadbike save(Quadbike quadbike) {
        if (quadbike.getId() == null) {
            return metodoCrud.save(quadbike);
        } else {
            Optional<Quadbike> respuesta = metodoCrud.getQuadbike(quadbike.getId());
            if (respuesta.isEmpty()) {
                return metodoCrud.save(quadbike);
            } else {
                return quadbike;
            }
        }
    }

    /**
     * update(Quadbike quadbike) Esta función actualiza información con un id de
     * cuatrimoto existente -> PUT - UPDATE
     *
     * @param quadbike
     * @return
     */
    public Quadbike update(Quadbike quadbike) {
        if (quadbike.getId() != null) {
            Optional<Quadbike> respuesta = metodoCrud.getQuadbike(quadbike.getId());
            if (!respuesta.isEmpty()) {
                if (quadbike.getName() != null) {
                    respuesta.get().setName(quadbike.getName());
                }
                if (quadbike.getBrand() != null) {
                    respuesta.get().setBrand(quadbike.getBrand());
                }
                if (quadbike.getYear() != null) {
                    respuesta.get().setYear(quadbike.getYear());
                }
                if (quadbike.getDescription() != null) {
                    respuesta.get().setDescription(quadbike.getDescription());
                }
                if (quadbike.getCategory() != null) {
                    respuesta.get().setCategory(quadbike.getCategory());
                }
                metodoCrud.save(respuesta.get());
                return respuesta.get();
            } else {
                return quadbike;
            }
        } else {
            return quadbike;
        }
    }

    /**
     * deleteQuadbike(int quadbikeId) Esta función elimina a partir de id de
     * cuatrimoto-> DELETE - DELETE
     *
     * @param quadbikeId
     * @return
     */
    public boolean deleteQuadbike(int quadbikeId) {
        Boolean aBoolean = getQuadbike(quadbikeId).map(quadbike -> {
            metodoCrud.delete(quadbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
