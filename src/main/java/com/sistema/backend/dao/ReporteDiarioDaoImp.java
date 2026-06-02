package com.sistema.backend.dao;

import com.sistema.backend.entity.ReporteDiario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class ReporteDiarioDaoImp implements ReporteDiarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<ReporteDiario> listarTodos() {
        return entityManager.createQuery("FROM ReporteDiario", ReporteDiario.class).getResultList();
    }

    @Override
    @Transactional
    public ReporteDiario guardar(ReporteDiario reporte) {
        return entityManager.merge(reporte);
    }

    @Override
    @Transactional(readOnly = true)
    public ReporteDiario buscarPorId(Long id) {
        return entityManager.find(ReporteDiario.class, id);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        ReporteDiario reporte = entityManager.find(ReporteDiario.class, id);
        if (reporte != null) {
            entityManager.remove(reporte);
        }
    }
}