package com.sistema.backend.dao;

import com.sistema.backend.entity.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class EstudianteDaoImp implements EstudianteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> listarTodos() {
        // Ejecuta una consulta JPQL para traer todos los registros de la entidad Estudiante
        return entityManager.createQuery("FROM Estudiante", Estudiante.class).getResultList();
    }

    @Override
    @Transactional
    public Estudiante guardar(Estudiante estudiante) {
        // Almacena o actualiza el estudiante en la base de datos
        return entityManager.merge(estudiante);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Estudiante est = entityManager.find(Estudiante.class, id);
        if (est != null) entityManager.remove(est);
    }

    @Override
    public Estudiante buscarPorId(Long id) {
        return entityManager.find(Estudiante.class, id);
    }
}