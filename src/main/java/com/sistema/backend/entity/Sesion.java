package com.sistema.backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sesiones")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sesion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora")
    private LocalDateTime fecha;

    private String linkGrabacion;
    private String temaPrincipal;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Sesion() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getLinkGrabacion() { return linkGrabacion; }
    public void setLinkGrabacion(String linkGrabacion) { this.linkGrabacion = linkGrabacion; }
    public String getTemaPrincipal() { return temaPrincipal; }
    public void setTemaPrincipal(String temaPrincipal) { this.temaPrincipal = temaPrincipal; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }

    private static final long serialVersionUID = 1L;
}