/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.CompraEquipo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface CompraEquipoService {
    
         public List<CompraEquipo> findAll();

    public List<CompraEquipo> findCustom();

    public Optional<CompraEquipo> findById(long id);

    public CompraEquipo add(CompraEquipo c);

    public CompraEquipo update(CompraEquipo c);

    public CompraEquipo delete(CompraEquipo c);

    public List<CompraEquipo> findAllCustom();
    
    CompraEquipo getCompraEquipoById(long id);

}
