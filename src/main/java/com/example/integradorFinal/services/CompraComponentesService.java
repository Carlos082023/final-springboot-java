/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.CompraComponente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface CompraComponentesService {

    public List<CompraComponente> findAll();

    public List<CompraComponente> findCustom();

    public Optional<CompraComponente> findById(long id);

    public CompraComponente add(CompraComponente c);

    public CompraComponente update(CompraComponente c);

    public CompraComponente delete(CompraComponente c);

    public List<CompraComponente> findAllCustom();

    CompraComponente getCompraComponenteById(long id);

}
