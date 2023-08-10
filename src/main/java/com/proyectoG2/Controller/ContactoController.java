
package com.proyectoG2.Controller;

import com.proyectoG2.Service.ContactoService;
import com.proyectoG2.domain.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Contactenos")
public class ContactoController {
    
    @Autowired
    ContactoService contactoService;
    
    @GetMapping
    public String contacto(){
        return "Contactenos";
    }
    
    @ModelAttribute("contacto") 
    public Contacto NuevoContacto(){
        return new Contacto();
    }
    
    @PostMapping
    public String save(@ModelAttribute("contacto") Contacto contacto){
        contactoService.save(contacto);
        return "redirect:/Contactenos?enviado";
    }
}
