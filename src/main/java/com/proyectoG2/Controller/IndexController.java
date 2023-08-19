
package com.proyectoG2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String page(Model model) {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping("/Servicios")
    public String services(){
        return "Servicios";
    }
    
    @RequestMapping("Actividades")
    public String actividades(){
        return "Actividades";
    }    
    
    @RequestMapping("Sedes")
    public String sedes(){
        return "Sedes";
    }
    
    @RequestMapping("PlanE")
    public String PlanE(){
        return "PlanE";
    }
    
    @RequestMapping("EnfoqueH")
    public String EnfoqueH(){
        return "EnfoqueH";
    }
    
    @RequestMapping("Profesores")
    public String Profesores(){
        return "Profesores";
    }
    
}
