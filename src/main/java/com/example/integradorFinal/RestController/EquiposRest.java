/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.RestController;

import com.example.integradorFinal.entity.Equipos;
import com.example.integradorFinal.services.EquiposService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Equipo")
public class EquiposRest {
    
    
     @Autowired
    private EquiposService service;

    @GetMapping
    public List<Equipos> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAllCustom")
    public List<Equipos> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Equipos> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Equipos add(@RequestBody Equipos e) {
        return service.add(e);
    }

    @PutMapping("/{id}")
    public Equipos update(@PathVariable Long id, @RequestBody Equipos e) {
        e.setId(id);
        return service.update(e);
    }

    @DeleteMapping("/{id}")
    public Equipos delete(@PathVariable Long id) {
        Equipos objequipo = new Equipos();
        objequipo.setEstado(false);
        return service.delete(Equipos.builder().id(id).build());
    }
}
