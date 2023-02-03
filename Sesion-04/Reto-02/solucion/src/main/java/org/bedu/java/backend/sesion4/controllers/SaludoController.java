package org.bedu.java.backend.sesion4.controllers;

import org.bedu.java.backend.sesion4.model.Saludo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @PutMapping("/saludo")
    public Saludo saluda(@RequestBody Saludo saludo){

        saludo.setFechaNacimiento(saludo.getFechaNacimiento().plusDays(1));

        return saludo;
    }
}
