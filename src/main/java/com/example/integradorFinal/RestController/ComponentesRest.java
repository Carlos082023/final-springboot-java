/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.RestController;

import com.example.integradorFinal.entity.Componentes;
import com.example.integradorFinal.services.ComponentesService;
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
@RequestMapping("/Componente")
public class ComponentesRest {
    
     @Autowired
    private ComponentesService service;

    @GetMapping
    public List<Componentes> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAllCustom")
    public List<Componentes> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Componentes> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Componentes add(@RequestBody Componentes c) {
        return service.add(c);
    }

    @PutMapping("/{id}")
    public Componentes update(@PathVariable Long id, @RequestBody Componentes c) {
        c.setId(id);
        return service.update(c);
    }

    @DeleteMapping("/{id}")
    public Componentes delete(@PathVariable Long id) {
        Componentes objcomponentes = new Componentes();
        objcomponentes.setEstado(false);
        return service.delete(Componentes.builder().id(id).build());
    }
}
