package org.bedu.java.backend.sesion5;

import org.bedu.java.backend.sesion5.model.Saludo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sesion5Application implements CommandLineRunner {

    private final Saludo saludo;

    public Sesion5Application(@Autowired Saludo saludo) {
        this.saludo = saludo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Sesion5Application.class, args);
    }


	@Override
	public void run(String... args) throws Exception {
		System.out.println(saludo.getNombre());
	}
}
