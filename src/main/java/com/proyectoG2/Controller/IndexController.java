
package com.proyectoG2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String page(Model model) {
        //model.addAttribute("attribute", "value");
        return "index";
    }
    
    @RequestMapping("/Servicios")
    public String services(){
        return "Servicios";
    }
    
    @RequestMapping("Contactenos")
    public String contacts(){
        return "Contactenos";
    }
    
    @RequestMapping("Matricula")
    public String matricula(){
        return "Matricula";
    }
    
    @RequestMapping("Sedes")
    public String sedes(){
        return "Sedes";
    }
    
    @RequestMapping("Tienda")
    public String tienda(){
        return "Tienda";
    }
    
}
