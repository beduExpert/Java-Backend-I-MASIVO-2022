package org.bedu.java.backend.sesion5.service;

import org.bedu.java.backend.sesion5.model.Saludo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaludoService {

    private final Saludo saludo;
    private final Saludo otroSaludo;

    @Autowired
    public SaludoService(Saludo saludo, Saludo otroSaludo) {
        this.saludo = saludo;
        this.otroSaludo = otroSaludo;

        System.out.println(saludo == otroSaludo);
    }

    public String saluda(){
        return "Hola " + saludo.getNombre();
    }
}
