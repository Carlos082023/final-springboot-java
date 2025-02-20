/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.Usuarios;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface UsuariosService {

    public List<Usuarios> findAll();

    public List<Usuarios> findAllCustom();

    public List<Usuarios> findCustom();

    public Optional<Usuarios> findById(long id);

    public Usuarios add(Usuarios u);

    public Usuarios update(Usuarios u);

    public Usuarios delete(Usuarios u);

    public Usuarios findByUser(String user);

    public Usuarios findByCorreo(String correo);

}
