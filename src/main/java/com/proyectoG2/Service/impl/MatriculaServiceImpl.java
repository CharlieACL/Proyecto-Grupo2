
package com.proyectoG2.Service.impl;

import com.proyectoG2.Service.MatriculaService;
import com.proyectoG2.dao.MatriculaDao;
import com.proyectoG2.domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaDao matriculaDao;
    
    @Override
    @Transactional
        public void save(Estudiante estudiante) {
        matriculaDao.save(estudiante);
    }
    
}
