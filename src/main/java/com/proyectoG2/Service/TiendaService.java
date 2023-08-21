package com.proyectoG2.Service;

import com.proyectoG2.domain.Tienda;
import java.util.List;


public interface TiendaService {
    
    public List<Tienda> getTiendas();
    
    public Tienda getTienda(Tienda tienda);

    public void save(Tienda tienda);

    public void delete(Tienda tienda);
}
