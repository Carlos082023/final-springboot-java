/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.Equipos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface EquiposService {
    
    public List<Equipos> findAll();

    public List<Equipos> findCustom();

    public Optional<Equipos> findById(long id);

    public Equipos add(Equipos e);

    public Equipos update(Equipos e);

    public Equipos delete(Equipos e);

    public List<Equipos> findAllCustom();
}
