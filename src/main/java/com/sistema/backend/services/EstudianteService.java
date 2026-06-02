package com.sistema.backend.services;

import com.sistema.backend.entity.Estudiante;
import com.sistema.backend.dao.EstudianteDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteDao estudianteDao;

    // Inyección por constructor de la interfaz (desacoplamiento total)
    public EstudianteService(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteDao.listarTodos();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteDao.guardar(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        estudianteDao.eliminar(id);
    }
}