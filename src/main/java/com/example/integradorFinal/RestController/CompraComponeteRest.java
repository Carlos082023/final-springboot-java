/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.RestController;

import com.example.integradorFinal.entity.CompraComponente;
import com.example.integradorFinal.services.CompraComponentesService;
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
@RequestMapping("/CompraComponente")
public class CompraComponeteRest {
    
      @Autowired
    private CompraComponentesService service;

    @GetMapping
    public List<CompraComponente> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAllCustom")
    public List<CompraComponente> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<CompraComponente> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CompraComponente add(@RequestBody CompraComponente c) {
        return service.add(c);
    }

    @PutMapping("/{id}")
    public CompraComponente update(@PathVariable Long id, @RequestBody CompraComponente c) {
        c.setId(id);
        return service.update(c);
    }

    @DeleteMapping("/{id}")
    public CompraComponente delete(@PathVariable Long id) {
        CompraComponente objcomprac = new CompraComponente();
        objcomprac.setEstado(false);
        return service.delete(CompraComponente.builder().id(id).build());
    }
}
