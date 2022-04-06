package org.bedu.java.backend.sesion4.controllers;

import org.bedu.java.backend.sesion4.model.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    @GetMapping("/saludo")
    public Saludo saluda() {

        Saludo saludo = new Saludo();
        saludo.setMensaje("¡¡Hola Mundo!!");

        return saludo;
    }
}
