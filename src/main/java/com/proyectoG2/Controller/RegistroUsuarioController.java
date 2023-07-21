package com.proyectoG2.Controller;

import com.proyectoG2.domain.Usuario;
import com.proyectoG2.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoG2.service.UsuarioService;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
    
    @Autowired
    private UsuarioService usuariosService;
    
    /*@ModelAttribute("usuarios")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        
        return new UsuarioRegistroDTO();
    }*/
    
    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }
    
    @PostMapping
    public String save(Usuario usuarios){
        usuariosService.save(usuarios);
        return "redirect:/registro?exito";
    }
    
    /*@PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuarios") UsuarioRegistroDTO registroDTO){
        usuariosService.save(registroDTO);
        return "redirect:/registro?exito";
    }*/
    
}
