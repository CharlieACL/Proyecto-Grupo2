package com.proyectoG2.Controller;

import com.proyectoG2.domain.Usuario;
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
    private UsuarioService usuarioService;
    
    @ModelAttribute("usuario") 
    public Usuario NuevoUsuario(){
        return new Usuario();
    }
    
    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }
    
    @PostMapping
    public String save(@ModelAttribute("usuario") Usuario usuario){
        usuarioService.save(usuario,true);
        return "redirect:/registro?exito";
    }
    
    
}
