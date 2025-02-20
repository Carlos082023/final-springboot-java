/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.RestController;

import com.example.integradorFinal.entity.CompraEquipo;
import com.example.integradorFinal.services.CompraEquipoService;
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
@RequestMapping("/CompraEquipo")
public class CompraEquipoRest {

    @Autowired
    private CompraEquipoService service;

    @GetMapping
    public List<CompraEquipo> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAllCustom")
    public List<CompraEquipo> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<CompraEquipo> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CompraEquipo add(@RequestBody CompraEquipo c) {
        return service.add(c);
    }

    @PutMapping("/{id}")
    public CompraEquipo update(@PathVariable Long id, @RequestBody CompraEquipo c) {
        c.setId(id);
        return service.update(c);
    }

    @DeleteMapping("/{id}")
    public CompraEquipo delete(@PathVariable Long id) {
        CompraEquipo objcomprae = new CompraEquipo();
        objcomprae.setEstado(false);
        return service.delete(CompraEquipo.builder().id(id).build());
    }
}
