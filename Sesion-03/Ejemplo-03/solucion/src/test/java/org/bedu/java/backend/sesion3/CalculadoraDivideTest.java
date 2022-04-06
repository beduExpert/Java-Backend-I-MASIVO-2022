package org.bedu.java.backend.sesion3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraDivideTest {

    static Calculadora calculadora;

    @BeforeAll
    static void setup() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Prueba division")
    void divideTest() {
        int esperado = 9;
        assertEquals(esperado, calculadora.divide(18, 2));
    }
}
