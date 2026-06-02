package com.sistema.backend.services;

import com.sistema.backend.entity.Sesion;
import com.sistema.backend.dao.SesionDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SesionService {

    private final SesionDao sesionDao;

    public SesionService(SesionDao sesionDao) {
        this.sesionDao = sesionDao;
    }

    public List<Sesion> listarSesiones() {
        return sesionDao.listarTodas();
    }

    public Sesion guardarSesion(Sesion sesion) {
        return sesionDao.guardar(sesion);
    }

    public Sesion buscarSesionPorId(Long id) {
        return sesionDao.buscarPorId(id);
    }

    public void eliminarSesion(Long id) {
        sesionDao.eliminar(id);
    }
}