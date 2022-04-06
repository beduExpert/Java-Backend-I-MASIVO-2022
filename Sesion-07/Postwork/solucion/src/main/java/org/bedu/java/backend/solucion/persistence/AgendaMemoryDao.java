package org.bedu.java.backend.solucion.persistence;

import org.bedu.java.backend.solucion.model.Persona;
import org.bedu.java.backend.solucion.service.FormateadorTelefono;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();
    private final FormateadorTelefono formateadorTelefono;

    public AgendaMemoryDao(FormateadorTelefono formateadorTelefono) {
        this.formateadorTelefono = formateadorTelefono;
    }

    public Persona guardaPersona(Persona persona) {
        persona.setTelefono(formateadorTelefono.formatea(persona.getTelefono()));
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
