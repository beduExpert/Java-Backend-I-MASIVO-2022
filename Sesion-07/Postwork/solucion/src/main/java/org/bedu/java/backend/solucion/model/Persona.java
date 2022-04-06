package org.bedu.java.backend.solucion.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class Persona implements Comparable<Persona> {

    @NotBlank(message = "El nombre de la persona es un campo obligatorio.")
    private String nombre;

    @Pattern(regexp = "^(\\d{2,4}[- .]?){2}\\d{4}$", message = "El teléfono debe tener un formato de ##-####-####")
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nombre.equals(persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.nombre);
    }
}