package com.sistema.backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reportes_diarios")
public class ReporteDiario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaGeneracion;

    @Column(columnDefinition = "TEXT")
    private String contenidoResumen;

    private Boolean enviado;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sesion_id")
    private Sesion sesion;

    public ReporteDiario() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }
    public String getContenidoResumen() { return contenidoResumen; }
    public void setContenidoResumen(String contenidoResumen) { this.contenidoResumen = contenidoResumen; }
    public Boolean getEnviado() { return enviado; }
    public void setEnviado(Boolean enviado) { this.enviado = enviado; }
    public Sesion getSesion() { return sesion; }
    public void setSesion(Sesion sesion) { this.sesion = sesion; }

    private static final long serialVersionUID = 1L;
}