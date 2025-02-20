/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.services;


import com.example.integradorFinal.entity.Componentes;
import com.example.integradorFinal.repositories.Icomponentes;
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
public class ComponentesServiceImplement  implements ComponentesService {
     @Autowired
        private Icomponentes icomponentes;
        
    @Override
    public List<Componentes> findAll() {
        return icomponentes.findAll();
    }
    
     @Override
    public List<Componentes> findCustom() {
        return icomponentes.findAllCustom();
    }
    
    @Override
    public List<Componentes> findAllCustom() {
          return icomponentes.findAllCustom();
    }

    @Override
    public Optional<Componentes> findById(long id) {
          return icomponentes.findById(id);
    }

    @Override
    public Componentes add(Componentes c) {
          return icomponentes.save(c);
    }

    @Override
    public Componentes update(Componentes c) {
        Componentes objcomponentes =icomponentes.getById(c.getId());
        BeanUtils.copyProperties(c, objcomponentes);
        return icomponentes.save(objcomponentes);
        
    }

    @Override
    public Componentes delete(Componentes c) {
        Componentes objcomponentes =icomponentes.getById(c.getId());   
        objcomponentes.setEstado(false);
        return icomponentes.save(objcomponentes);
        
    }

    
}
