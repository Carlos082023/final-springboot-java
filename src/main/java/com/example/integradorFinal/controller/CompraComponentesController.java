/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Clientes;
import com.example.integradorFinal.entity.Componentes;
import com.example.integradorFinal.entity.CompraComponente;
import com.example.integradorFinal.services.ClientesService;
import com.example.integradorFinal.services.ComponentesService;
import com.example.integradorFinal.services.CompraComponentesService;
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
public class CompraComponentesController {

    @Autowired
    private CompraComponentesService service;

    @Autowired
    private ClientesService clientesservice;

    @Autowired
    private ComponentesService componentesservice;

    @RequestMapping("/CompraComponentes")
    public String viewHomePage(Model model) {
        List<CompraComponente> listCompraComponente = service.findAll();
        model.addAttribute("listCompraComponente", listCompraComponente);
        return ("CompraComponente");
    }

    @RequestMapping("/newCompraComponentes")
    public String showNewCompraComponenteForm(Model model) {
        CompraComponente compraComponente = new CompraComponente();
        model.addAttribute("compraComponente", compraComponente);
        List<Clientes> listClientes = clientesservice.findAllCustom();
        model.addAttribute("listClientes", listClientes);
        List<Componentes> listComponentes = componentesservice.findAllCustom();
        model.addAttribute("listComponentes", listComponentes);
        return "New_CompraComponente";
    }

    @RequestMapping(value = "/saveCompraComponente", method = RequestMethod.POST)
    public String saveCompraEquipo(@ModelAttribute("compraComponente") CompraComponente compraComponente, RedirectAttributes redirectAttributes, Model model) {
        try {
            if (compraComponente.getId() != 0) {
                // Es una edición de compra existente
                CompraComponente originalCompraComponente = service.getCompraComponenteById(compraComponente.getId());

                // Verificar si la cantidad ha cambiado
                if (compraComponente.getCantidad() != originalCompraComponente.getCantidad()) {
                    Componentes componentes = originalCompraComponente.getComponentes();
                    int stockDisponible = componentes.getStock();
                    int diferenciaCantidad = compraComponente.getCantidad() - originalCompraComponente.getCantidad();

                    // Verificar si hay suficiente stock disponible
                    if (stockDisponible >= diferenciaCantidad) {
                        // Restar la diferencia de cantidad del stock disponible
                        int stockActualizado = stockDisponible - diferenciaCantidad;
                        componentes.setStock(stockActualizado);
                    } else {
                        throw new RuntimeException("No hay suficiente stock disponible para la compra");
                    }
                }

                // Actualizar los demás campos del objeto originalCompraEquipo con los valores modificados
                originalCompraComponente.setCantidad(compraComponente.getCantidad());
                originalCompraComponente.setFecha(compraComponente.getFecha());
                originalCompraComponente.setComponentes(compraComponente.getComponentes());
                originalCompraComponente.setClientes(compraComponente.getClientes());
                originalCompraComponente.setEstado(compraComponente.isEstado());

                service.update(originalCompraComponente);
            } else {
               
                service.add(compraComponente);
            }

            return "redirect:/CompraComponentes";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "No hay suficiente stock disponible para la compra");
            model.addAttribute("compraComponente", compraComponente);
            if (compraComponente.getId() != 0) {
                return "redirect:/editCompraComponentes/" + compraComponente.getId();
            } else {
                return "redirect:/newCompraComponentes";
            }
        }
    }

    @RequestMapping("/editCompraComponentes/{id}")
    public ModelAndView showEditCompraEquipoForm(@PathVariable(name = "id") CompraComponente c) {
        ModelAndView mav = new ModelAndView("Edit_CompraComponente");
        CompraComponente compraComponente = service.update(c);
        mav.addObject("compraComponente", compraComponente);
        List<Clientes> listClientes = clientesservice.findAllCustom();
        mav.addObject("listClientes", listClientes);
        List<Componentes> listComponentes = componentesservice.findAllCustom();
        mav.addObject("listComponentes", listComponentes);
        return mav;
    }

    @RequestMapping("/deleteCompraComponentes/{id}")
    public String DeleteCompraComponente(@PathVariable(name = "id") CompraComponente c) {

        service.delete(c);
        return "redirect:/CompraComponentes";

    }
}
