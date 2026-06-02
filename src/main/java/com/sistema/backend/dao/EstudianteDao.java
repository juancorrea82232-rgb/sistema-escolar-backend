package com.sistema.backend.dao;

import com.sistema.backend.entity.Estudiante;
import java.util.List;

public interface EstudianteDao {
    List<Estudiante> listarTodos();
    Estudiante guardar(Estudiante estudiante);
    void eliminar(Long id); // Nuevo
    Estudiante buscarPorId(Long id); // Nuevo
}