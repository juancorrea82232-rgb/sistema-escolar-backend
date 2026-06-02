package com.sistema.backend.services;

import com.sistema.backend.entity.Asistencia;
import com.sistema.backend.dao.AsistenciaDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsistenciaService {

    private final AsistenciaDao asistenciaDao;

    public AsistenciaService(AsistenciaDao asistenciaDao) {
        this.asistenciaDao = asistenciaDao;
    }

    public List<Asistencia> listarAsistencias() {
        return asistenciaDao.listarTodas();
    }

    public Asistencia guardarAsistencia(Asistencia asistencia) {
        return asistenciaDao.guardar(asistencia);
    }

    public Asistencia buscarAsistenciaPorId(Long id) {
        return asistenciaDao.buscarPorId(id);
    }

    public void eliminarAsistencia(Long id) {
        asistenciaDao.eliminar(id);
    }
}