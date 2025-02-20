/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.RestController;

import com.example.integradorFinal.entity.Empleados;
import com.example.integradorFinal.services.EmpleadosService;
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
@RequestMapping("/Empleado")
public class EmpleadosRest {
   
     @Autowired
    private EmpleadosService service;

    @GetMapping
    public List<Empleados> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAllCustom")
    public List<Empleados> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Empleados> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Empleados add(@RequestBody Empleados e) {
        return service.add(e);
    }

    @PutMapping("/{id}")
    public Empleados update(@PathVariable Long id, @RequestBody Empleados e) {
        e.setId(id);
        return service.update(e);
    }

    @DeleteMapping("/{id}")
    public Empleados delete(@PathVariable Long id) {
        Empleados objempleados = new Empleados();
        objempleados.setEstado(false);
        return service.delete(Empleados.builder().id(id).build());
    }
}
