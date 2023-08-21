package com.proyectoG2.Controller;

import com.proyectoG2.Service.ProductoService;
import com.proyectoG2.Service.TiendaService;
import com.proyectoG2.Service.impl.FirebaseStorageServiceImpl;
import com.proyectoG2.domain.Producto;
import com.proyectoG2.domain.Tienda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Producto")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;
    
    @Autowired
    TiendaService categoriaService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping
    public String listado (Model model){
        List<Producto> productos = productoService.getProductos(false);
        List<Tienda> categorias = categoriaService.getTiendas(); 
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", productos.size());
        
        return "/Producto";
    }
    
    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/Producto/modifica";
    }
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/Producto";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/Producto";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        List<Tienda> categorias = categoriaService.getTiendas();
        model.addAttribute("categorias", categorias);
        model.addAttribute("producto", producto);
        return "/Producto/modifica";
    }
}
