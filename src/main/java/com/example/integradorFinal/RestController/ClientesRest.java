/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.RestController;

import com.example.integradorFinal.entity.Clientes;
import com.example.integradorFinal.services.ClientesService;
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
@RequestMapping("/Cliente")
public class ClientesRest {

    @Autowired
    private ClientesService service;

    @GetMapping
    public List<Clientes> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAllCustom")
    public List<Clientes> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Clientes add(@RequestBody Clientes c) {
        return service.add(c);
    }

    @PutMapping("/{id}")
    public Clientes update(@PathVariable Long id, @RequestBody Clientes c) {
        c.setId(id);
        return service.update(c);
    }

    @DeleteMapping("/{id}")
    public Clientes delete(@PathVariable Long id) {
        Clientes objclientes = new Clientes();
        objclientes.setEstado(false);
        return service.delete(Clientes.builder().id(id).build());
    }
}
