package com.sistema.backend.dao;

import com.sistema.backend.entity.Sesion;
import java.util.List;

public interface SesionDao {
    List<Sesion> listarTodas();
    Sesion guardar(Sesion sesion);
    Sesion buscarPorId(Long id);
    void eliminar(Long id);
}