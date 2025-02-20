package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Usuarios;
import com.example.integradorFinal.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuariosService service;

    @GetMapping("/login1")
    public String viewLoginPage(Model model) {
        model.addAttribute("usuarios", new Usuarios());
        return "login1";
    }

    @RequestMapping(value = "/Register/save", method = RequestMethod.POST)
    public String saveUsuarios(@ModelAttribute("usuarios") Usuarios usuarios, @RequestParam("password") String password) {
        if (usuarios.getPassword().equals(password)) {
            service.add(usuarios);
          
        }
        return "redirect:/index";
    }

}
