/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.repositories;

import com.example.integradorFinal.entity.CompraComponente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface IcompraComponente extends JpaRepository<CompraComponente, Long>{
   @Query("Select c from CompraComponente c where c.estado = true ")
    List<CompraComponente> findAllCustom();
    
}
