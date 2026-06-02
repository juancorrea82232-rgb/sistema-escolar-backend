package com.sistema.backend.dao;

import com.sistema.backend.entity.Sesion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class SesionDaoImp implements SesionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Sesion> listarTodas() {
        return entityManager.createQuery("FROM Sesion", Sesion.class).getResultList();
    }

    @Override
    @Transactional
    public Sesion guardar(Sesion sesion) {
        return entityManager.merge(sesion);
    }

    @Override
    @Transactional(readOnly = true)
    public Sesion buscarPorId(Long id) {
        return entityManager.find(Sesion.class, id);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Sesion sesion = entityManager.find(Sesion.class, id);
        if (sesion != null) {
            entityManager.remove(sesion);
        }
    }
}