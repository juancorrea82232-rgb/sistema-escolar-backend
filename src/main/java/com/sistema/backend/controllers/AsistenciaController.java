package com.sistema.backend.controllers;

import com.sistema.backend.entity.Asistencia;
import com.sistema.backend.services.AsistenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @GetMapping
    public List<Asistencia> listar() {
        return asistenciaService.listarAsistencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> buscarPorId(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.buscarAsistenciaPorId(id);
        if (asistencia != null) {
            return ResponseEntity.ok(asistencia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Asistencia> crear(@RequestBody Asistencia asistencia) {
        return ResponseEntity.ok(asistenciaService.guardarAsistencia(asistencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> actualizar(@PathVariable Long id, @RequestBody Asistencia asistencia) {
        asistencia.setId(id);
        return ResponseEntity.ok(asistenciaService.guardarAsistencia(asistencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        asistenciaService.eliminarAsistencia(id);
        return ResponseEntity.noContent().build();
    }
}