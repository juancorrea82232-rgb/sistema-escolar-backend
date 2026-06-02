package com.sistema.backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "asistencias")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Asistencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sesion_id")
    private Sesion sesion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    private String estado; // PRESENTE, AUSENTE, EXCUSA
    private String comentario;

    public Asistencia() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Sesion getSesion() { return sesion; }
    public void setSesion(Sesion sesion) { this.sesion = sesion; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    private static final long serialVersionUID = 1L;
}