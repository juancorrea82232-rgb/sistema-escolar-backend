package com.sistema.backend.dao;

import com.sistema.backend.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class CursoDaoImp implements CursoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listarTodos() {
        return entityManager.createQuery("FROM Curso", Curso.class).getResultList();
    }

    @Override
    @Transactional
    public Curso guardar(Curso curso) {
        return entityManager.merge(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso buscarPorId(Long id) {
        return entityManager.find(Curso.class, id);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Curso curso = entityManager.find(Curso.class, id);
        if (curso != null) {
            entityManager.remove(curso);
        }
    }
}