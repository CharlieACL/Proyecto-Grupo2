package com.proyectoG2.dao;

import com.proyectoG2.domain.Tienda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaDao extends JpaRepository <Tienda,Long>{
    public List<Tienda> findByPrecioBetweenOrderByPrecio(double precioInf, double precioSup);;
}
