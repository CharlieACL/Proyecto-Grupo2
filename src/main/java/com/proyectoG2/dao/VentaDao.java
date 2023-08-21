package com.proyectoG2.dao;

import com.proyectoG2.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDao extends JpaRepository <Venta,Long> {
    
}
