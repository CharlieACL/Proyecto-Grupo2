
package com.proyectoG2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_contacto")
    private Long IdContacto;
    private String nombre;
    private String correo;
    private String telefono;
    private String mensaje;

    public Contacto(String nombre, String correo, String telefono, String mensaje) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    public Contacto() {
    }
    
    
    
}
