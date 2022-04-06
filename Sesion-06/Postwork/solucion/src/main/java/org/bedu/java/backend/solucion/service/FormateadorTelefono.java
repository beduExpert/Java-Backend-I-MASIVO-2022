package org.bedu.java.backend.solucion.service;

import org.springframework.stereotype.Service;

@Service
public class FormateadorTelefono {
    private static final String FORMATO_INICIAL_TELEFONO = "(\\d{2})(\\d{4})(\\d+)";
    private static final String FORMATO_FINAL_TELEFONO = "($1)-$2-$3";

    public String formatea(String telefono) {
        return String.valueOf(telefono).replaceFirst(FORMATO_INICIAL_TELEFONO, FORMATO_FINAL_TELEFONO);
    }
}
