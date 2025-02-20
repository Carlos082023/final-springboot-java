/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Componentes;
import com.example.integradorFinal.services.ComponentesService;
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
public class ComponentesController {
    
        @Autowired
    private ComponentesService service;
    
     @RequestMapping("/Componentes")
    public String viewHomePage(Model model){
        List<Componentes> listComponentes = service.findAll();
        model.addAttribute("listComponentes",listComponentes);
        return("Componentes");
    }
    @RequestMapping("/newComponentes")
     public String showNewComponenteForm(Model model){
     Componentes componentes = new Componentes();
     model.addAttribute("componentes",componentes);
     return "New_Componentes";
     }
     
      @RequestMapping(value="/saveComponentes", method = RequestMethod.POST)
       public String saveComponente(@ModelAttribute("Componentes")Componentes componentes){
           service.add(componentes);
           return "redirect:/Componentes";
       
       }
       
        @RequestMapping("/editComponentes/{id}")
         public ModelAndView showEditComponentesForm(@PathVariable(name="id")Componentes c){
         ModelAndView mav = new ModelAndView("Edit_Componentes");
         Componentes componentes = service.update(c);
         mav.addObject("componentes",componentes);
         return mav;
         }
         
         @RequestMapping("/deleteComponentes/{id}")
          public String DeleteComponente(@PathVariable(name="id")Componentes c){
                   
                    service.delete(c);
                     return "redirect:/Componentes";
                    
            }
    
}
