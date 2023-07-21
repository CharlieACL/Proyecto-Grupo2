package com.proyectoG2.dao;

import com.proyectoG2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario,Long>{
    
    Usuario findByUsername(String username);
}
