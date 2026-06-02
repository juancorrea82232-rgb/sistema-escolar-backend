package com.sistema.backend.controllers;

import com.sistema.backend.entity.Usuario;
import com.sistema.backend.dao.UsuarioDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Permite que tu frontend en React se conecte
public class AuthController {

    @Autowired
    private UsuarioDao usuarioRepository; // Cambia el nombre si usaste UsuarioDao

    // --- 1. ENDPOINT PARA REGISTRAR NUEVO USUARIO ---
    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        Map<String, Object> respuesta = new HashMap<>();

        // Validamos si el email ya existe en la base de datos
        if (usuarioRepository.existsByEmail(nuevoUsuario.getEmail())) {
            respuesta.put("mensaje", "Error: El correo ya está registrado");
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }

        // 🚨 LA MAGIA AQUÍ: Encriptamos la contraseña antes de guardarla
        String passwordEncriptada = BCrypt.hashpw(nuevoUsuario.getPassword(), BCrypt.gensalt());
        nuevoUsuario.setPassword(passwordEncriptada);

        // Si no nos envían un rol desde React, le asignamos 'DOCENTE' por defecto
        if (nuevoUsuario.getRol() == null || nuevoUsuario.getRol().isEmpty()) {
            nuevoUsuario.setRol("DOCENTE");
        }

        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);
        
        // Borramos la contraseña de la respuesta por seguridad (para no devolverla al navegador)
        usuarioGuardado.setPassword(null);
        
        respuesta.put("mensaje", "Usuario registrado con éxito");
        respuesta.put("usuario", usuarioGuardado);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    // --- 2. ENDPOINT PARA INICIAR SESIÓN ---
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        Map<String, Object> respuesta = new HashMap<>();

        // Buscamos al usuario por su email
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(loginRequest.getEmail());

        if (usuarioOpt.isPresent()) {
            Usuario usuarioDb = usuarioOpt.get();
            
            // 🚨 COMPROBAMOS SI LAS CONTRASEÑAS COINCIDEN (Texto plano vs Encriptada)
            if (BCrypt.checkpw(loginRequest.getPassword(), usuarioDb.getPassword())) {
                
                usuarioDb.setPassword(null); // Ocultamos la contraseña antes de enviarla
                respuesta.put("mensaje", "Inicio de sesión exitoso");
                respuesta.put("usuario", usuarioDb);
                return new ResponseEntity<>(respuesta, HttpStatus.OK);
                
            } else {
                respuesta.put("mensaje", "Credenciales inválidas (contraseña incorrecta)");
                return new ResponseEntity<>(respuesta, HttpStatus.UNAUTHORIZED);
            }
        } else {
            respuesta.put("mensaje", "Credenciales inválidas (usuario no encontrado)");
            return new ResponseEntity<>(respuesta, HttpStatus.UNAUTHORIZED);
        }
    }

    // 🚨 ENDPOINT TEMPORAL PARA DAR PERMISOS DE ADMIN (Borrar en producción)
    @GetMapping("/hacer-admin/{email}")
    public ResponseEntity<?> hacerAdmin(@PathVariable String email) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setRol("ADMIN");
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("¡Éxito! El usuario " + email + " ahora es ADMIN.");
        }
        return ResponseEntity.badRequest().body("Usuario no encontrado.");
    }
}