package com.example.integradorFinal.controller;

import com.example.integradorFinal.entity.Usuarios;
import com.example.integradorFinal.services.UsuariosService;
import java.util.List;
import java.util.Optional;
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
public class UsuariosController {

    @Autowired
    private UsuariosService serviceusuarios;

    @RequestMapping("/Usuarios")
    public String viewHomePage(Model model) {
        List<Usuarios> listUsuarios = serviceusuarios.findAll();
        model.addAttribute("listUsuarios", listUsuarios);
        return ("Usuarios");
    }

   
    @RequestMapping("/newUsuarios")
    public String showNewUsuarioForm(Model model) {
        Usuarios usuarios = new Usuarios();
        model.addAttribute("usuarios", usuarios);
        return "New_Usuarios";
    }

@RequestMapping(value = "/saveUsuarios", method = RequestMethod.POST)
public String saveUsuarios(@ModelAttribute("usuarios") Usuarios usuarios, Model model) {
    // Validar que el nombre de usuario no sea igual a otro existente
    Usuarios existeUser = serviceusuarios.findByUser(usuarios.getUser());
    if (existeUser != null && existeUser.getId() != usuarios.getId()) {
        model.addAttribute("error1", "El nombre de usuario ya existe");
        model.addAttribute("usuarios", usuarios);
        return usuarios.getId() == 0 ? "New_Usuarios" : "Edit_Usuarios";
    }

    // Validar que el correo electrónico no sea igual al de otro usuario existente
    Usuarios existeCorreo = serviceusuarios.findByCorreo(usuarios.getCorreo());
    if (existeCorreo != null && existeCorreo.getId() != usuarios.getId()) {
        model.addAttribute("error2", "El correo electrónico ya está en uso por otro usuario");
        model.addAttribute("usuarios", usuarios);
        return usuarios.getId() == 0 ? "New_Usuarios" : "Edit_Usuarios";
    }

    // Validar el formato de correo electrónico
    if (!isValidEmail(usuarios.getCorreo())) {
        model.addAttribute("error", "El formato de correo electrónico no es válido");
        model.addAttribute("usuarios", usuarios);
        return usuarios.getId() == 0 ? "New_Usuarios" : "Edit_Usuarios";
    }

    if (usuarios.getId() == 0) {
        // Agregar un nuevo usuario
        serviceusuarios.add(usuarios);
    } else {
        // Actualizar el usuario existente
        Usuarios existingUser = serviceusuarios.findById(usuarios.getId()).orElse(null);

        if (existingUser != null) {
            // Verificar si el nombre de usuario se ha actualizado
            if (!existingUser.getUser().equals(usuarios.getUser())) {
                Usuarios userWithNewUsername = serviceusuarios.findByUser(usuarios.getUser());
                if (userWithNewUsername != null) {
                    model.addAttribute("error1", "El nombre de usuario ya existe");
                    model.addAttribute("usuarios", usuarios);
                    return "Edit_Usuarios";
                }
            }

            // Verificar si el correo electrónico se ha actualizado
            if (!existingUser.getCorreo().equals(usuarios.getCorreo())) {
                Usuarios userWithNewEmail = serviceusuarios.findByCorreo(usuarios.getCorreo());
                if (userWithNewEmail != null) {
                    model.addAttribute("error2", "El correo electrónico ya está en uso por otro usuario");
                    model.addAttribute("usuarios", usuarios);
                    return "Edit_Usuarios";
                }
            }

            // Actualizar los demás campos del usuario
            existingUser.setTipo_documento(usuarios.getTipo_documento());
            existingUser.setDocumento(usuarios.getDocumento());
            existingUser.setNacionalidad(usuarios.getNacionalidad());
            existingUser.setUser(usuarios.getUser());
            existingUser.setPassword(usuarios.getPassword());
            existingUser.setRol(usuarios.getRol());
            existingUser.setCorreo(usuarios.getCorreo());
            existingUser.setTelefono(usuarios.getTelefono());
            existingUser.setFecha_alta(usuarios.getFecha_alta());
            existingUser.setFecha_baja(usuarios.getFecha_baja());
            existingUser.setEstado(usuarios.isEstado());

            serviceusuarios.update(existingUser);
        }
    }

    return "redirect:/Usuarios";
}



    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    @RequestMapping("/editUsuarios/{id}")
    public ModelAndView showEditUsuarioForm(@PathVariable(name = "id") Usuarios u) {
        ModelAndView mav = new ModelAndView("Edit_Usuarios");
        Usuarios usuarios = serviceusuarios.update(u);
        mav.addObject("usuarios", usuarios);
        return mav;
    }

    @RequestMapping("/deleteUsuarios/{id}")
    public String DeleteUsuario(@PathVariable(name = "id") Usuarios u) {
        //Categorias obj= new Categorias();
        //obj.setEstado(false);
        serviceusuarios.delete(u);
        return "redirect:/Usuarios";

    }
}
