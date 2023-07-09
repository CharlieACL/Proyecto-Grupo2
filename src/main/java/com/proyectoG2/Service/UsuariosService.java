package com.proyectoG2.service;

import com.proyectoG2.dto.UsuarioRegistroDTO;
import com.proyectoG2.domain.Usuarios;

public interface UsuariosService {
    
    public Usuarios save(UsuarioRegistroDTO registroDTO);
}
