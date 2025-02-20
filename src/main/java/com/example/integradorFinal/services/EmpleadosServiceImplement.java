/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.Componentes;
import com.example.integradorFinal.entity.Empleados;
import com.example.integradorFinal.repositories.Iempleados;
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
public class EmpleadosServiceImplement implements EmpleadosService{
    
     @Autowired
        private Iempleados iempleados;
        
    @Override
    public List<Empleados> findAll() {
        return iempleados.findAll();
    }
    
     @Override
    public List<Empleados> findCustom() {
        return iempleados.findAllCustom();
    }
    
    @Override
    public List<Empleados> findAllCustom() {
          return iempleados.findAllCustom();
    }

    @Override
    public Optional<Empleados> findById(long id) {
          return iempleados.findById(id);
    }

    @Override
    public Empleados add(Empleados e) {
          return iempleados.save(e);
    }

    @Override
    public Empleados update(Empleados e) {
        Empleados objempleados =iempleados.getById(e.getId());
        BeanUtils.copyProperties(e, objempleados);
        return iempleados.save(objempleados);
        
    }

    @Override
    public Empleados delete(Empleados e) {
        Empleados objempleados =iempleados.getById(e.getId());   
        objempleados.setEstado(false);
        return iempleados.save(objempleados);
        
    }
}
