package com.sistema.backend.dao;

import com.sistema.backend.entity.Asistencia;
import java.util.List;

public interface AsistenciaDao {
    List<Asistencia> listarTodas();
    Asistencia guardar(Asistencia asistencia);
    Asistencia buscarPorId(Long id);
    void eliminar(Long id);
}