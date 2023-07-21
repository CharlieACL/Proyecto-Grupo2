package com.proyectoG2.service;

import com.proyectoG2.dto.UsuarioRegistroDTO;
import com.proyectoG2.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioService {
    
   public void save(Usuario usuario);
    
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
