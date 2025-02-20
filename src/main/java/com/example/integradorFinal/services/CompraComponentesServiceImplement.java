/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.Componentes;
import com.example.integradorFinal.entity.CompraComponente;
import com.example.integradorFinal.repositories.Icomponentes;
import com.example.integradorFinal.repositories.IcompraComponente;
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
public class CompraComponentesServiceImplement implements CompraComponentesService {

    @Autowired
    private IcompraComponente icompracomponente;
    
      @Autowired
    private Icomponentes icomponentes;

    @Override
    public List<CompraComponente> findAll() {
        return icompracomponente.findAll();
    }

    @Override
    public List<CompraComponente> findCustom() {
        return icompracomponente.findAllCustom();
    }

    @Override
    public List<CompraComponente> findAllCustom() {
        return icompracomponente.findAllCustom();
    }

    @Override
    public Optional<CompraComponente> findById(long id) {
        return icompracomponente.findById(id);
    }

   /* @Override
    public CompraComponente add(CompraComponente c) {
        return icompracomponente.save(c);
    }*/
    
        @Override
    public CompraComponente add(CompraComponente c) {
        Componentes componentes = c.getComponentes();
        int cantidadComprada = c.getCantidad();
        int stockDisponible = componentes.getStock();

        // Verificar si hay suficiente stock disponible
        if (stockDisponible >= cantidadComprada) {
            // Restar la cantidad de equipos comprados del stock disponible
            int stockActualizado = stockDisponible - cantidadComprada;
            componentes.setStock(stockActualizado);

            // Guardar la compra y actualizar el stock en la base de datos
            icomponentes.save(componentes);
            return icompracomponente.save(c);
        } else {
            throw new RuntimeException("No hay suficiente stock disponible para la compra");
        }
    }

    @Override
    public CompraComponente update(CompraComponente c) {
        CompraComponente objcomprac = icompracomponente.getById(c.getId());
        BeanUtils.copyProperties(c, objcomprac);
        return icompracomponente.save(objcomprac);

    }

    @Override
    public CompraComponente delete(CompraComponente c) {
        CompraComponente objcomprac = icompracomponente.getById(c.getId());
        objcomprac.setEstado(false);
        return icompracomponente.save(objcomprac);

    }
    
    
    @Override
    public CompraComponente getCompraComponenteById(long id) {
        return icompracomponente.findById(id).orElse(null);
    }
    
    
     
}
