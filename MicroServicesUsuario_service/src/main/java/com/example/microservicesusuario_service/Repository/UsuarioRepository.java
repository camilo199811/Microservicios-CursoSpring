package com.example.microservicesusuario_service.Repository;

import com.example.microservicesusuario_service.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
