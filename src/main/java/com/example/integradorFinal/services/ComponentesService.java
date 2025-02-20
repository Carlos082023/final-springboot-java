/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.services;


import com.example.integradorFinal.entity.Componentes;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface ComponentesService {
    
      public List<Componentes> findAll();

    public List<Componentes> findCustom();

    public Optional<Componentes> findById(long id);

    public Componentes add(Componentes c);

    public Componentes update(Componentes c);

    public Componentes delete(Componentes c);

    public List<Componentes> findAllCustom();
}
