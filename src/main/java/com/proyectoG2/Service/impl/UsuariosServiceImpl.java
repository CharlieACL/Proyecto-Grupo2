
package com.proyectoG2.service.impl;

import com.proyectoG2.dao.UsuariosDao;
import com.proyectoG2.domain.Rol;
import com.proyectoG2.domain.Usuarios;
import com.proyectoG2.dto.UsuarioRegistroDTO;
import com.proyectoG2.service.UsuariosService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service("userDetailsService")
public class UsuariosServiceImpl implements UsuariosService, UserDetailsService{

    
    @Autowired
    private UsuariosDao usuariosDao;
    
    @Override
    public Usuarios save(UsuarioRegistroDTO registroDTO) {
        Usuarios usuarios = new Usuarios(registroDTO.getNombreUsuario(), 
        registroDTO.getCorreoElectronico(), 
        registroDTO.getContraseña(), 
        registroDTO.getTelefono(), Arrays.asList(new Rol("ROLE_USER")));
        return usuariosDao.save(usuarios);
    }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuarios=usuariosDao.findByNombreUsuario(username);
        
        if(usuarios==null){
            throw new UsernameNotFoundException(username);
        }
        
        return new User(usuarios.getNombreUsuario(),usuarios.getContraseña(),mapearRoles(usuarios.getRoles()));      
    }
    
    
    private Collection<? extends GrantedAuthority> mapearRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

 }
