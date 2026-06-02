package com.sistema.backend.dao;

import com.sistema.backend.entity.ReporteDiario;
import java.util.List;

public interface ReporteDiarioDao {
    List<ReporteDiario> listarTodos();
    ReporteDiario guardar(ReporteDiario reporte);
    ReporteDiario buscarPorId(Long id);
    void eliminar(Long id);
}