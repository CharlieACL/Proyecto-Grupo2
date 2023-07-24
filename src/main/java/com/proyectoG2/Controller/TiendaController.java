package com.proyectoG2.Controller;

import com.proyectoG2.Service.TiendaService;
import com.proyectoG2.domain.Tienda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Tienda")
public class TiendaController {
    @Autowired
    TiendaService tiendaService;
    
     @GetMapping
    public String listado (Model model){
        List<Tienda> tiendas = tiendaService.getTiendas();
        model.addAttribute("tiendas", tiendas);
        model.addAttribute("totalTiendas", tiendas.size());
        
        return "Tienda";
    }
}
