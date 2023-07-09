package com.proyectoG2.Controller;

import com.proyectoG2.dto.UsuarioRegistroDTO;
import com.proyectoG2.service.UsuariosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
    
    private UsuariosService usuariosService;

    public RegistroUsuarioController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }
    
    @ModelAttribute("usuarios")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        
        return new UsuarioRegistroDTO();
    }
    
    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }
    
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuarios") UsuarioRegistroDTO registroDTO){
        usuariosService.save(registroDTO);
        return "redirect:/registro?exito";
    }
    
}
