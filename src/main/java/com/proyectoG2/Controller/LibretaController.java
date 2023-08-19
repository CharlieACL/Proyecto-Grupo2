/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyectoG2.Controller;

import com.proyectoG2.Service.EstudianteService;
import com.proyectoG2.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LibretaController {
    
    @Autowired 
    private EstudianteService estudianteService;
    
    @GetMapping("/libreta/listado")
    public String page(Model model) {
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("TotalEstudiantes", estudiantes.size());    
        return "/libreta/listado";
    }
    
    @PostMapping("/libreta/guardar")
    public String guardar(Estudiante estudiante){
        estudianteService.save(estudiante);
        return "redirect:/libreta/listado";
    }
    
    @GetMapping("/libreta/eliminar/{idEstudiante}")
    public String eliminar(Estudiante estudiante){
        estudianteService.delete(estudiante);
        return "redirect:/libreta/listado";
    }
    
    @GetMapping("/libreta/estudiante/{idEstudiante}")
    public String verEstudiante(Estudiante estudiante, Model model){
        estudiante = estudianteService.getEstudiante(estudiante);
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("estudiante", estudiante);
        return "/libreta/estudiante";
    }
    
}
