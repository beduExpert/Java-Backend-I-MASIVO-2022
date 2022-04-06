package org.bedu.java.backend.solucion.controller;

import org.bedu.java.backend.solucion.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {


    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(Usuario usuario) {
        ModelAndView mav = new ModelAndView("registroExitoso");
        mav.addObject("usuario", usuario);
        return mav;
    }

}
