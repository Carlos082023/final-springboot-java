/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.services;


import com.example.integradorFinal.entity.Empleados;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface EmpleadosService {
    
       public List<Empleados> findAll();

    public List<Empleados> findCustom();

    public Optional<Empleados> findById(long id);

    public Empleados add(Empleados e);

    public Empleados update(Empleados e);

    public Empleados delete(Empleados e);

    public List<Empleados> findAllCustom();
}
