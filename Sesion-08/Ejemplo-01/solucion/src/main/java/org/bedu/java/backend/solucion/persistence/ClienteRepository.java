package org.bedu.java.backend.solucion.persistence;

import org.bedu.java.backend.solucion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

}