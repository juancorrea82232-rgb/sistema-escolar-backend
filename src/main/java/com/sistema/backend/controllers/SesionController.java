package com.sistema.backend.controllers;

import com.sistema.backend.entity.Sesion;
import com.sistema.backend.services.SesionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
@CrossOrigin(origins = "*")
public class SesionController {

    private final SesionService sesionService;

    public SesionController(SesionService sesionService) {
        this.sesionService = sesionService;
    }

    @GetMapping
    public List<Sesion> listar() {
        return sesionService.listarSesiones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesion> buscarPorId(@PathVariable Long id) {
        Sesion sesion = sesionService.buscarSesionPorId(id);
        if (sesion != null) {
            return ResponseEntity.ok(sesion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sesion> crear(@RequestBody Sesion sesion) {
        return ResponseEntity.ok(sesionService.guardarSesion(sesion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sesion> actualizar(@PathVariable Long id, @RequestBody Sesion sesion) {
        sesion.setId(id);
        return ResponseEntity.ok(sesionService.guardarSesion(sesion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        sesionService.eliminarSesion(id);
        return ResponseEntity.noContent().build();
    }
}