/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Clientes;
import com.example.integradorFinal.entity.CompraEquipo;
import com.example.integradorFinal.entity.Equipos;
import com.example.integradorFinal.services.ClientesService;
import com.example.integradorFinal.services.CompraEquipoService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CompraEquiposController {

    @Autowired
    private CompraEquipoService service;
    @Autowired
    private ClientesService serviceClientes;
    @Autowired
    private EquiposService serviceEquipos;

    @RequestMapping("/CompraEquipos")
    public String viewHomePage(Model model) {
        List<CompraEquipo> listCompraEquipo = service.findAll();
        model.addAttribute("listCompraEquipo", listCompraEquipo);
        return ("CompraEquipo");
    }

    @RequestMapping("/newCompraEquipos")
    public String showNewCompraEquipoForm(Model model) {
        CompraEquipo compraEquipo = new CompraEquipo();
        model.addAttribute("compra_equipos", compraEquipo);
        List<Clientes> listClientes = serviceClientes.findAllCustom();
        model.addAttribute("listClientes", listClientes);
        List<Equipos> listEquipos = serviceEquipos.findAllCustom();
        model.addAttribute("listEquipos", listEquipos);

        return "New_CompraEquipo";
    }

    @RequestMapping(value = "/saveCompraEquipo", method = RequestMethod.POST)
public String saveCompraEquipo(@ModelAttribute("compraEquipo") CompraEquipo compraEquipo, RedirectAttributes redirectAttributes, Model model) {
    try {
        if (compraEquipo.getId() != 0) {
            // Es una edición de compra existente
            CompraEquipo originalCompraEquipo = service.getCompraEquipoById(compraEquipo.getId());
            
            // Verificar si la cantidad ha cambiado
            if (compraEquipo.getCantidad() != originalCompraEquipo.getCantidad()) {
                Equipos equipo = originalCompraEquipo.getEquipos();
                int stockDisponible = equipo.getStock();
                int diferenciaCantidad = compraEquipo.getCantidad() - originalCompraEquipo.getCantidad();
    
                // Verificar si hay suficiente stock disponible
                if (stockDisponible >= diferenciaCantidad) {
                    // Restar la diferencia de cantidad del stock disponible
                    int stockActualizado = stockDisponible - diferenciaCantidad;
                    equipo.setStock(stockActualizado);
                } else {
                    throw new RuntimeException("No hay suficiente stock disponible para la compra");
                }
            }
    
            // Actualizar los demás campos del objeto originalCompraEquipo con los valores modificados
            originalCompraEquipo.setCantidad(compraEquipo.getCantidad());
            originalCompraEquipo.setFecha(compraEquipo.getFecha());
            originalCompraEquipo.setEquipos(compraEquipo.getEquipos());
            originalCompraEquipo.setClientes(compraEquipo.getClientes());
            originalCompraEquipo.setEstado(compraEquipo.isEstado());
    
            // Guardar los cambios en la base de datos
            service.update(originalCompraEquipo);
        } else {
            // Es una nueva compra
            service.add(compraEquipo);
        }

        return "redirect:/CompraEquipos";
    } catch (RuntimeException e) {
        redirectAttributes.addFlashAttribute("error", "No hay suficiente stock disponible para la compra");
        model.addAttribute("compraEquipo", compraEquipo);
        if (compraEquipo.getId() != 0) {
            return "redirect:/editCompraEquipo/" + compraEquipo.getId();
        } else {
            return "redirect:/newCompraEquipos";
        }
    }
}

    @RequestMapping("/editCompraEquipo/{id}")
    public ModelAndView showEditCompraEquipoForm(@PathVariable(name = "id") CompraEquipo c) {
        ModelAndView mav = new ModelAndView("Edit_CompraEquipo");
        CompraEquipo compraEquipo = service.update(c);
        mav.addObject("compra_equipos", compraEquipo);
        List<Clientes> listClientes = serviceClientes.findAllCustom();
        mav.addObject("listClientes", listClientes);
        List<Equipos> listEquipos = serviceEquipos.findAllCustom();
        mav.addObject("listEquipos", listEquipos);
        return mav;
    }

    @RequestMapping("/deleteCompraEquipo/{id}")
    public String DeleteCompraEquipo(@PathVariable(name = "id") CompraEquipo c) {

        service.delete(c);
        return "redirect:/CompraEquipos";

    }

}
