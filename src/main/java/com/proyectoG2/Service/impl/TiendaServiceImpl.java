package com.proyectoG2.Service.impl;

import com.proyectoG2.Service.TiendaService;
import com.proyectoG2.dao.TiendaDao;
import com.proyectoG2.domain.Tienda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TiendaServiceImpl implements TiendaService{
    @Autowired
    TiendaDao tiendaDao;

    
    @Transactional(readOnly = true)
    public List<Tienda> getTiendas() {
        List<Tienda> tiendas = tiendaDao.findAll();
        return tiendas;
    }

    
    @Transactional(readOnly = true)
    public Tienda getTienda(Tienda tienda) {
        return tiendaDao.findById(tienda.getIdTienda()).orElse(null);
    }
}
