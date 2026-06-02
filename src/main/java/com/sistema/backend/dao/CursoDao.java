package com.sistema.backend.dao;

import com.sistema.backend.entity.Curso; // Asegúrate de importar la entidad correcta
import java.util.List;

public interface CursoDao {
    List<Curso> listarTodos();
    Curso guardar(Curso curso);
    Curso buscarPorId(Long id);
    void eliminar(Long id);
}