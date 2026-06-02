package com.sistema.backend.controllers;

import com.sistema.backend.entity.ReporteDiario;
import com.sistema.backend.services.ReporteDiarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteDiarioController {

    private final ReporteDiarioService reporteService;

    public ReporteDiarioController(ReporteDiarioService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping
    public List<ReporteDiario> listar() {
        return reporteService.listarReportes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteDiario> buscarPorId(@PathVariable Long id) {
        ReporteDiario reporte = reporteService.buscarReportePorId(id);
        if (reporte != null) {
            return ResponseEntity.ok(reporte);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ReporteDiario> crear(@RequestBody ReporteDiario reporte) {
        return ResponseEntity.ok(reporteService.guardarReporte(reporte));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteDiario> actualizar(@PathVariable Long id, @RequestBody ReporteDiario reporte) {
        reporte.setId(id);
        return ResponseEntity.ok(reporteService.guardarReporte(reporte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reporteService.eliminarReporte(id);
        return ResponseEntity.noContent().build();
    }
}