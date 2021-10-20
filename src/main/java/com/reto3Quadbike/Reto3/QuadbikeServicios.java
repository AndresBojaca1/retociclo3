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
public class QuadbikeServicios {
    
    @Autowired
    private QuadbikeRepositorio metodoCrud;
    
    public List<Quadbike> getAll(){
        return metodoCrud.getAll();
    }

    public Optional<Quadbike> getQuadbike(int quadbikeId) {
        return metodoCrud.getQuadbike(quadbikeId);
    }

    public Quadbike save(Quadbike quadbike){
        if (quadbike.getId() == null){
            return metodoCrud.save(quadbike);
        }else{
            Optional<Quadbike> respuesta = metodoCrud.getQuadbike(quadbike.getId());
            if (respuesta.isEmpty()){
                return metodoCrud.save(quadbike);
            }else{
                return quadbike;
            }
        }
    }

    public Quadbike update(Quadbike quadbike){
        if (quadbike.getId()!= null){
            Optional<Quadbike> respuesta = metodoCrud.getQuadbike(quadbike.getId());
            if(!respuesta.isEmpty()){
                if(quadbike.getName() != null){
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
            }else{
                return quadbike;
            }
        }else{
            return quadbike;
        }
    }

    public boolean deleteQuadbike(int quadbikeId) {
        Boolean aBoolean = getQuadbike(quadbikeId).map(quadbike -> {
            metodoCrud.delete(quadbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }    
}
