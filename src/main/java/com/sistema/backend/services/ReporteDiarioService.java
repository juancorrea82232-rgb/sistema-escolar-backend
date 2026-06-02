package com.sistema.backend.services;

import com.sistema.backend.entity.ReporteDiario;
import com.sistema.backend.dao.ReporteDiarioDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReporteDiarioService {

    private final ReporteDiarioDao reporteDiarioDao;

    public ReporteDiarioService(ReporteDiarioDao reporteDiarioDao) {
        this.reporteDiarioDao = reporteDiarioDao;
    }

    public List<ReporteDiario> listarReportes() {
        return reporteDiarioDao.listarTodos();
    }

    public ReporteDiario guardarReporte(ReporteDiario reporte) {
        return reporteDiarioDao.guardar(reporte);
    }

    public ReporteDiario buscarReportePorId(Long id) {
        return reporteDiarioDao.buscarPorId(id);
    }

    public void eliminarReporte(Long id) {
        reporteDiarioDao.eliminar(id);
    }
}