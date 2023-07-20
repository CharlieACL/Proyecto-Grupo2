package com.proyectoG2.dao;

import com.proyectoG2.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios,Long>{
    
    Usuarios findByNombreUsuario(String nombreUsuario);
}
