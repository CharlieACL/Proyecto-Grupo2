package com.proyectoG2.dao;

import com.proyectoG2.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatriculaDao extends JpaRepository<Matricula, Long>{
    
}
