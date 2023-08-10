
package com.proyectoG2.dao;

import com.proyectoG2.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao extends JpaRepository<Contacto, Long>{
    
}
