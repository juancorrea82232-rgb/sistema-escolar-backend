package com.sistema.backend.controllers;

import com.sistema.backend.entity.Estudiante;
import com.sistema.backend.services.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*") // ¡Clave! Permite que tu frontend en React se conecte sin bloqueos de seguridad (CORS)
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    // Petición GET: http://localhost:8080/api/estudiantes
    @GetMapping
    public List<Estudiante> listarTodos() {
        return service.listarEstudiantes();
    }

    // Petición POST: http://localhost:8080/api/estudiantes
    @PostMapping
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = service.guardarEstudiante(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarEstudiante(id);
    }

@PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id); // Aseguramos que el ID sea el del objeto a editar
        return ResponseEntity.ok(service.guardarEstudiante(estudiante));
}
}