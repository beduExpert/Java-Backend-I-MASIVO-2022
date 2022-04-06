package org.bedu.java.backend.sesion5.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Saludo {
    private final String nombre;

    public Saludo() {
        this.nombre = "Beto";

        System.out.println("Creando una instancia de Saludo");
    }

    public String getNombre() {
        return nombre;
    }
}
