package com.proyectoG2.service;

import com.proyectoG2.dto.UsuarioRegistroDTO;
import com.proyectoG2.domain.Usuarios;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuariosService {
    
    public Usuarios save(UsuarioRegistroDTO registroDTO);
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
