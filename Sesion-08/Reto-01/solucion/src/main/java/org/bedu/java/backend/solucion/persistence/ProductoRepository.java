package org.bedu.java.backend.solucion.persistence;

import org.bedu.java.backend.solucion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}