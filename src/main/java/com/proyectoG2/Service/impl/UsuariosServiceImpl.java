
package com.proyectoG2.service.impl;

import com.proyectoG2.dao.UsuariosDao;
import com.proyectoG2.domain.Rol;
import com.proyectoG2.domain.Usuarios;
import com.proyectoG2.dto.UsuarioRegistroDTO;
import com.proyectoG2.service.UsuariosService;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    private UsuariosDao usuariosDao;

    public UsuariosServiceImpl(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }
    
    @Override
    public Usuarios save(UsuarioRegistroDTO registroDTO) {
        Usuarios usuarios = new Usuarios(registroDTO.getNombreUsuario(), 
        registroDTO.getCorreoElectronico(), 
        registroDTO.getContraseña(), 
        registroDTO.getTelefono(), Arrays.asList(new Rol("Role_User")));
        return usuariosDao.save(usuarios);
    }

   
    
    
    }
