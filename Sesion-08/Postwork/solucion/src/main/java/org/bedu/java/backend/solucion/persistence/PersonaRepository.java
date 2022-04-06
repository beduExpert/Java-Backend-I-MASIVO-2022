package org.bedu.java.backend.solucion.persistence;

import org.bedu.java.backend.solucion.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
