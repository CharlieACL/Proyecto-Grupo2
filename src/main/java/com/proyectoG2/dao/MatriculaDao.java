package com.proyectoG2.dao;

import com.proyectoG2.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatriculaDao extends JpaRepository<Estudiante, Long>{
    
}
