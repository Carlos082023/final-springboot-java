/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Clientes;
import com.example.integradorFinal.services.ClientesService;
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
public class ClientesController {
    @Autowired
    private ClientesService service;
    
     @RequestMapping("/Clientes")
    public String viewHomePage(Model model){
        List<Clientes> listClientes = service.findAll();
        model.addAttribute("listClientes",listClientes);
        return("Clientes");
    }
    @RequestMapping("/newClientes")
     public String showNewClienteForm(Model model){
     Clientes cliente = new Clientes();
     model.addAttribute("clientes",cliente);
     return "New_Cliente";
     }
     
      @RequestMapping(value="/saveClientes", method = RequestMethod.POST)
       public String saveCliente(@ModelAttribute("Clientes")Clientes clientes){
           service.add(clientes);
           return "redirect:/Clientes";
       
       }
       
        @RequestMapping("/editClientes/{id}")
         public ModelAndView showEditClienteForm(@PathVariable(name="id")Clientes c){
         ModelAndView mav = new ModelAndView("Edit_Cliente");
         Clientes clientes = service.update(c);
         mav.addObject("clientes",clientes);
         return mav;
         }
         
         @RequestMapping("/deleteClientes/{id}")
          public String DeleteCliente(@PathVariable(name="id")Clientes c){
                   
                    service.delete(c);
                     return "redirect:/Clientes";
                    
            }
    
    
}
