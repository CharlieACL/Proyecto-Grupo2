
package com.proyectoG2.Controller;


import com.proyectoG2.Service.MatriculaService;
import com.proyectoG2.domain.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Matricula")
public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;
    
    @GetMapping
    public String matricula(){
        return "Matricula";
    }
    
    @ModelAttribute("matricula") 
    public Matricula NuevoUsuario(){
        return new Matricula();
    }
    
    @PostMapping
    public String save(@ModelAttribute("matricula") Matricula matricula){
        matriculaService.save(matricula);
        return "redirect:/index";
    }
    
}
