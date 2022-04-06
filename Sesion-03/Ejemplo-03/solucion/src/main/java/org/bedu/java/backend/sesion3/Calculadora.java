package org.bedu.java.backend.sesion3;

public class Calculadora {

    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplica(int a, int b) {
        return a * b;
    }

    public float divide(float a, float b) {

        if (b == 0) {
            throw new IllegalArgumentException("No es posible dividir un valor entre 0");
        }

        return a / b;
    }
}