/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.repositories;


import com.example.integradorFinal.entity.Equipos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Iequipos extends JpaRepository<Equipos, Long>{
   @Query("Select e from Equipos e where e.estado = true ")
    List<Equipos> findAllCustom();
    
}
