package com.sistema.backend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estudiantes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    // 1. Constructor vacío (Obligatorio para JPA)
    public Estudiante() {
    }

    // 2. Constructor con parámetros
    public Estudiante(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // 3. Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}