/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.Usuarios;
import com.example.integradorFinal.repositories.Iusuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImplement implements UsuariosService {

    @Autowired
    private Iusuarios iusuarios;

    @Autowired
    private BCryptPasswordEncoder BCrypt;

    @Override
    public List<Usuarios> findAll() {
        return iusuarios.findAll();
    }

    @Override
    public List<Usuarios> findCustom() {
        return iusuarios.findAllCustom();
    }

    @Override
    public List<Usuarios> findAllCustom() {
        return iusuarios.findAllCustom();
    }

    @Override
    public Optional<Usuarios> findById(long id) {
        return iusuarios.findById(id);
    }

    @Override
    public Usuarios add(Usuarios u) {
        u.setPassword(BCrypt.encode(u.getPassword()));
        return iusuarios.save(u);
    }

    @Override
    public Usuarios update(Usuarios u) {
        Usuarios objusuarios = iusuarios.getById(u.getId());
        u.setPassword(BCrypt.encode(u.getPassword()));
        BeanUtils.copyProperties(u, objusuarios);
        return iusuarios.save(objusuarios);

    }

    @Override
    public Usuarios delete(Usuarios u) {
        Usuarios objusuario = iusuarios.getById(u.getId());
        objusuario.setEstado(false);
        return iusuarios.save(objusuario);

    }

    @Override
    public Usuarios findByUser(String user) {
        return iusuarios.findByUser(user);
    }

    @Override
    public Usuarios findByCorreo(String correo) {
        return iusuarios.findByCorreo(correo);
    }
    
}
