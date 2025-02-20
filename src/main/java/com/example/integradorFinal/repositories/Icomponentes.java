/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.repositories;


import com.example.integradorFinal.entity.Componentes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Icomponentes  extends JpaRepository<Componentes, Long>{
   @Query("Select c from Componentes c where c.estado = true ")
    List<Componentes> findAllCustom();
    
}
