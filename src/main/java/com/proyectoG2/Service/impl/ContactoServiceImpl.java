
package com.proyectoG2.Service.impl;

import com.proyectoG2.Service.ContactoService;
import com.proyectoG2.dao.ContactoDao;
import com.proyectoG2.domain.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    private ContactoDao contactoDao;
    
    @Override
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }
        
    
}
