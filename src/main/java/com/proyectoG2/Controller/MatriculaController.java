
package com.proyectoG2.Controller;


import com.google.firebase.internal.FirebaseService;
import com.proyectoG2.Service.FirebaseStorageService;
import com.proyectoG2.Service.MatriculaService;
import com.proyectoG2.domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("Matricula")
public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;
    
    @Autowired
    private FirebaseStorageService firebaseService;
    
    @GetMapping
    public String matricula(){
        return "Matricula";
    }
    
    @ModelAttribute("estudiante") 
    public Estudiante NuevoEstudiante(){
        return new Estudiante();
    }
    
    @PostMapping
    public String save(@ModelAttribute("estudiante") Estudiante estudiante,
            @RequestParam("imagenFile") MultipartFile imagenFile){
        if(!imagenFile.isEmpty()){
            matriculaService.save(estudiante);
            estudiante.setImagen(firebaseService.cargaImagen(imagenFile, 
            "estudiante", estudiante.getIdEstudiante()));
        }
        matriculaService.save(estudiante);
        return "redirect:/Matricula?exito";
    }
    
}
