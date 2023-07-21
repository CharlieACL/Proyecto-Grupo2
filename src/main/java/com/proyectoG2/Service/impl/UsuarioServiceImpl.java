
package com.proyectoG2.service.impl;

import com.proyectoG2.domain.Rol;
import com.proyectoG2.domain.Usuario;
import com.proyectoG2.dto.UsuarioRegistroDTO;
import jakarta.servlet.http.HttpSession;
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
import com.proyectoG2.dao.UsuarioDao;
import com.proyectoG2.service.UsuarioService;

@Service("userDetailsService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{

    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    /*@Override
    public Usuarios save(UsuarioRegistroDTO registroDTO) {
        Usuarios usuarios = new Usuarios(registroDTO.getNombreUsuario(), 
        registroDTO.getCorreoElectronico(), 
        registroDTO.getContraseña(), 
        registroDTO.getTelefono(), Arrays.asList(new Rol("ROLE_USER")));
        return usuariosDao.save(usuarios);
    }*/
    
    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarios=usuarioDao.findByUsername(username);
        
        if(usuarios==null){
            throw new UsernameNotFoundException(username);
        }
        
        var roles=new ArrayList<GrantedAuthority>();
        
        for (Rol rol: usuarios.getRoles()){
           roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuarios.getUsername(), usuarios.getPassword(),roles);
    }
    
    
    /*private Collection<? extends GrantedAuthority> mapearRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }*/
    
}
