/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Equipos;
import com.example.integradorFinal.services.EquiposService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author carlo
 */
@Controller
public class EquiposController {

    @Autowired
    private EquiposService service;

    @RequestMapping("/Equipos")
    public String viewHomePage(Model model) {
        List<Equipos> listEquipos = service.findAll();
        model.addAttribute("listEquipos", listEquipos);
        return ("Equipos");
    }

    @RequestMapping("/newEquipos")
    public String showNewEquiposForm(Model model) {
        Equipos equipos = new Equipos();
        model.addAttribute("equipos", equipos);
        return "New_Equipos";
    }

    @RequestMapping(value = "/saveEquipos", method = RequestMethod.POST)
    public String saveEquipos(@ModelAttribute("Equipos") Equipos equipos) {
        service.add(equipos);
        return "redirect:/Equipos";

    }

    @RequestMapping("/editEquipos/{id}")
    public ModelAndView showEditEquiposForm(@PathVariable(name = "id") Equipos e) {
        ModelAndView mav = new ModelAndView("Edit_Equipos");
        Equipos equipos = service.update(e);
        mav.addObject("equipos", equipos);
        return mav;
    }

    @RequestMapping("/deleteEquipos/{id}")
    public String DeleteEquipos(@PathVariable(name = "id") Equipos e) {

        service.delete(e);
        return "redirect:/Equipos";

    }

}
