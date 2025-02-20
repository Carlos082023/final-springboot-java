/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.services;


import com.example.integradorFinal.entity.Equipos;
import com.example.integradorFinal.repositories.Iequipos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlo
 */
@Service
public class EquiposServiceImplement implements EquiposService {
    
         @Autowired
        private Iequipos iequipos;
        
    @Override
    public List<Equipos> findAll() {
        return iequipos.findAll();
    }
    
     @Override
    public List<Equipos> findCustom() {
        return iequipos.findAllCustom();
    }
    
    @Override
    public List<Equipos> findAllCustom() {
          return iequipos.findAllCustom();
    }

    @Override
    public Optional<Equipos> findById(long id) {
          return iequipos.findById(id);
    }

    @Override
    public Equipos add(Equipos e) {
          return iequipos.save(e);
    }

    @Override
    public Equipos update(Equipos e) {
        Equipos objequipos =iequipos.getById(e.getId());
        BeanUtils.copyProperties(e, objequipos);
        return iequipos.save(objequipos);
        
    }

    @Override
    public Equipos delete(Equipos e) {
        Equipos objequipos =iequipos.getById(e.getId());   
        objequipos.setEstado(false);
        return iequipos.save(objequipos);
        
    }
}
