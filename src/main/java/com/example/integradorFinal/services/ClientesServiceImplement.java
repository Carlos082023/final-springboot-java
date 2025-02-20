/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.Clientes;
import com.example.integradorFinal.repositories.Iclientes;
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
public class ClientesServiceImplement  implements ClientesService {
     @Autowired
        private Iclientes iclientes;
        
    @Override
    public List<Clientes> findAll() {
        return iclientes.findAll();
    }
    
     @Override
    public List<Clientes> findCustom() {
        return iclientes.findAllCustom();
    }
    
    @Override
    public List<Clientes> findAllCustom() {
          return iclientes.findAllCustom();
    }

    @Override
    public Optional<Clientes> findById(long id) {
          return iclientes.findById(id);
    }

    @Override
    public Clientes add(Clientes c) {
          return iclientes.save(c);
    }

    @Override
    public Clientes update(Clientes c) {
        Clientes objclientes =iclientes.getById(c.getId());
        BeanUtils.copyProperties(c, objclientes);
        return iclientes.save(objclientes);
        
    }

    @Override
    public Clientes delete(Clientes c) {
        Clientes objclientes =iclientes.getById(c.getId());   
        objclientes.setEstado(false);
        return iclientes.save(objclientes);
        
    }

    
}
