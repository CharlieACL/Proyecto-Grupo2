
package com.proyectoG2.dao;

import com.proyectoG2.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudianteDao extends JpaRepository<Estudiante, Long>{
    
}
