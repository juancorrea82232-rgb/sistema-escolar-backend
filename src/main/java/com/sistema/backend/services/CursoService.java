package com.sistema.backend.services;

import com.sistema.backend.entity.Curso;
import com.sistema.backend.dao.CursoDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {

    private final CursoDao cursoDao;

    public CursoService(CursoDao cursoDao) {
        this.cursoDao = cursoDao;
    }

    public List<Curso> listarCursos() {
        return cursoDao.listarTodos();
    }

    public Curso guardarCurso(Curso curso) {
        // Aquí podrías agregar validaciones a futuro (ej. que el grupo no esté vacío)
        return cursoDao.guardar(curso);
    }

    public Curso buscarCursoPorId(Long id) {
        return cursoDao.buscarPorId(id);
    }

    public void eliminarCurso(Long id) {
        cursoDao.eliminar(id);
    }
}