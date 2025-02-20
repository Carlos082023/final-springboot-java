/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Empleados;
import com.example.integradorFinal.services.EmpleadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpleadosController {

    @Autowired
    private EmpleadosService service;

    @RequestMapping("/Empleados")
    public String viewHomePage(Model model) {
        List<Empleados> listEmpleados = service.findAll();
        model.addAttribute("listEmpleados", listEmpleados);
        return ("Empleados");
    }

    @RequestMapping("/newEmpleados")
    public String showNewEmpleadosForm(Model model) {
        Empleados empleados = new Empleados();
        model.addAttribute("empleados", empleados);
        return "New_Empleados";
    }

    @RequestMapping(value = "/saveEmpleados", method = RequestMethod.POST)
    public String saveEmpleados(@ModelAttribute("Empleados") Empleados empleados) {
        service.add(empleados);
        return "redirect:/Empleados";

    }

    @RequestMapping("/editEmpleados/{id}")
    public ModelAndView showEditEmpleadosForm(@PathVariable(name = "id") Empleados e) {
        ModelAndView mav = new ModelAndView("Edit_Empleados");
        Empleados empleados = service.update(e);
        mav.addObject("empleados", empleados);
        return mav;
    }

    @RequestMapping("/deleteEmpleados/{id}")
    public String DeleteEmpleados(@PathVariable(name = "id") Empleados e) {

        service.delete(e);
        return "redirect:/Empleados";

    }

}
