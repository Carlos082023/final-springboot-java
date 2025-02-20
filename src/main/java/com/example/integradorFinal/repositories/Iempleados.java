/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.repositories;

import com.example.integradorFinal.entity.Empleados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Iempleados extends JpaRepository<Empleados, Long>{
   @Query("Select e from Empleados e where e.estado = true")
    List<Empleados> findAllCustom();
    
}
