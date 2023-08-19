
package com.proyectoG2.Service.impl;

import com.proyectoG2.Service.EstudianteService;
import com.proyectoG2.dao.EstudianteDao;
import com.proyectoG2.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteDao estudianteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> getEstudiantes() {
        return estudianteDao.findAll();     
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante getEstudiante(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getIdEstudiante()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }
}
