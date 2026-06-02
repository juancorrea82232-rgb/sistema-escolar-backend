package com.sistema.backend.dao;

import com.sistema.backend.entity.Asistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class AsistenciaDaoImp implements AsistenciaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Asistencia> listarTodas() {
        return entityManager.createQuery("FROM Asistencia", Asistencia.class).getResultList();
    }

    @Override
    @Transactional
    public Asistencia guardar(Asistencia asistencia) {
        return entityManager.merge(asistencia);
    }

    @Override
    @Transactional(readOnly = true)
    public Asistencia buscarPorId(Long id) {
        return entityManager.find(Asistencia.class, id);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Asistencia asistencia = entityManager.find(Asistencia.class, id);
        if (asistencia != null) {
            entityManager.remove(asistencia);
        }
    }
}