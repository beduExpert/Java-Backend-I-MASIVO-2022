package org.bedu.java.backend.solucion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaludoController {

    @GetMapping("/hola")
    public ModelAndView hola(@RequestParam(name = "mensaje") String mensaje) {
        ModelAndView mav = new ModelAndView("hola");
        mav.addObject("mensaje", mensaje);
        return mav;
    }

}
