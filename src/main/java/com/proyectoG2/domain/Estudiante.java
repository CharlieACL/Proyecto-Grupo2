
package com.proyectoG2.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_estudiante")
    private Long idEstudiante;
    private String nombre;
    private String apellido;
    private String sede;
    private String nivel;
    private String observaciones;
    private String madre;
    private String padre;
    private String contacto;
    private String alergias;
    private String condicion;
    private int edad;
    private boolean asistencia;
    private String imagen;

    public Estudiante(String nombre, String apellido, String sede, String nivel, String observaciones, String madre, String padre, String contacto, String alergias, String condicion, boolean asistencia, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sede = sede;
        this.nivel = nivel;
        this.observaciones = observaciones;
        this.madre = madre;
        this.padre = padre;
        this.contacto = contacto;
        this.alergias = alergias;
        this.condicion = condicion;
        this.asistencia = asistencia;
        this.imagen = imagen;
    }

    public Estudiante() {
    }
    
    
}
