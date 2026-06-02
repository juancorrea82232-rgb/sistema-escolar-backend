package com.sistema.backend.dao; // O .dao, dependiendo de tu estructura

import com.sistema.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    // Este método es "mágico". Spring Boot automáticamente creará la consulta SQL
    // "SELECT * FROM usuarios WHERE email = ?"
    Optional<Usuario> findByEmail(String email);
    
    // Útil para validar si un correo ya está registrado antes de crear la cuenta
    boolean existsByEmail(String email);
}