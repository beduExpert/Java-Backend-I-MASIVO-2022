package org.bedu.java.backend.solucion;

import org.bedu.java.backend.solucion.model.Persona;
import org.bedu.java.backend.solucion.service.FormateadorTelefono;
import org.bedu.java.backend.solucion.service.ValidadorTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SolucionApplication implements CommandLineRunner {

    private final ValidadorTelefono validadorTelefono;
    private final FormateadorTelefono formateadorTelefono;

    @Autowired
    public SolucionApplication(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono) {
        this.validadorTelefono = validadorTelefono;
        this.formateadorTelefono = formateadorTelefono;
    }

    public static void main(String[] args) {
        SpringApplication.run(SolucionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        String nombre = reader.nextLine();

        System.out.println("Introduce el teléfono: ");
        String telefono = reader.nextLine();

        if (validadorTelefono.isValido(telefono)) {
            telefono = validadorTelefono.limpiaNumero(telefono);
            telefono = formateadorTelefono.formatea(telefono);

            Persona persona = new Persona(nombre, telefono);

            System.out.println(persona);
        } else {
            System.out.println("Por favor, introduce un número válido");
        }
    }
}
