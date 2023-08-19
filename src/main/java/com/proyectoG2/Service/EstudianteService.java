
package com.proyectoG2.Service;

import com.proyectoG2.domain.Estudiante;
import java.util.List;

public interface EstudianteService {
    
    public List<Estudiante> getEstudiantes();
    
    public Estudiante getEstudiante(Estudiante estudiante);
    
    public void save(Estudiante estudiante);
    
    public void delete(Estudiante estudiante);
    
}
