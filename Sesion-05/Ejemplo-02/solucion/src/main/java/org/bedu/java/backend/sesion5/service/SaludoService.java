package org.bedu.java.backend.sesion5.service;

import org.bedu.java.backend.sesion5.model.Saludo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaludoService {

    private final Saludo saludo;

    @Autowired
    public SaludoService(Saludo saludo) {
        this.saludo = saludo;
    }

    public String saluda(){
        return "Hola " + saludo.getNombre();
    }
}
