/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.CompraEquipo;
import com.example.integradorFinal.entity.Equipos;
import com.example.integradorFinal.repositories.IcompraEquipo;
import com.example.integradorFinal.repositories.Iequipos;
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
public class CompraEquipoServiceImplement implements CompraEquipoService {

    @Autowired
    private IcompraEquipo icompraequipo;

    @Autowired
    private Iequipos iequipos;

    @Override
    public List<CompraEquipo> findAll() {
        return icompraequipo.findAll();
    }

    @Override
    public List<CompraEquipo> findCustom() {
        return icompraequipo.findAllCustom();
    }

    @Override
    public List<CompraEquipo> findAllCustom() {
        return icompraequipo.findAllCustom();
    }

    @Override
    public Optional<CompraEquipo> findById(long id) {
        return icompraequipo.findById(id);
    }

    /* @Override
    public CompraEquipo add(CompraEquipo c) {
        return icompraequipo.save(c);
    }*/
    @Override
    public CompraEquipo update(CompraEquipo c) {
        CompraEquipo objcomprae = icompraequipo.getById(c.getId());
        BeanUtils.copyProperties(c, objcomprae);
        return icompraequipo.save(objcomprae);

    }

    @Override
    public CompraEquipo delete(CompraEquipo c) {
        CompraEquipo objcomprae = icompraequipo.getById(c.getId());
        objcomprae.setEstado(false);
        return icompraequipo.save(objcomprae);

    }

    @Override
    public CompraEquipo add(CompraEquipo c) {
        Equipos equipo = c.getEquipos();
        int cantidadComprada = c.getCantidad();
        int stockDisponible = equipo.getStock();

        // Verificar si hay suficiente stock disponible
        if (stockDisponible >= cantidadComprada) {
            // Restar la cantidad de equipos comprados del stock disponible
            int stockActualizado = stockDisponible - cantidadComprada;
            equipo.setStock(stockActualizado);

            // Guardar la compra y actualizar el stock en la base de datos
            iequipos.save(equipo);
            return icompraequipo.save(c);
        } else {
            throw new RuntimeException("No hay suficiente stock disponible para la compra");
        }
    }

    @Override
    public CompraEquipo getCompraEquipoById(long id) {
        return icompraequipo.findById(id).orElse(null);
    }

}
