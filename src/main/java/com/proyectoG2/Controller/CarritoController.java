package com.proyectoG2.Controller;

import com.proyectoG2.Service.ItemService;
import com.proyectoG2.Service.ProductoService;
import com.proyectoG2.Service.TiendaService;
import com.proyectoG2.domain.Item;
import com.proyectoG2.domain.Producto;
import com.proyectoG2.domain.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CarritoController {
 @Autowired
    private ItemService itemService;
    @Autowired
//    private ProductoService productoService;
    private TiendaService tiendaService;
    
    @GetMapping("/Carrito")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", 
                carritoTotalVenta);
        return "Carrito";
    }    
   
    @GetMapping("/carrito/agregar/{idTienda}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Tienda tienda = tiendaService.getTienda(item);
            item2 = new Item(tienda);
//            Producto producto = productoService.getProducto(item);
//            item2 = new Item(producto);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("layout/plantillaCarrito :: verCarrito");
    }


    @GetMapping("/carrito/eliminar/{idTienda}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/Carrito?eliminado";
    }

    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/Carrito";
    }

}
