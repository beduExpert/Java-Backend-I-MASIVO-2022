package org.bedu.java.backend.sesion5.model;

import org.springframework.stereotype.Component;

@Component
public class Saludo {
    private final String nombre;

    public Saludo() {
        this.nombre = "Beto";
    }

    public String getNombre() {
        return nombre;
    }
}
