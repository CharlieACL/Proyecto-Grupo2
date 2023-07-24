package com.proyectoG2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "tienda")
public class Tienda implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_tienda")
    private Long idTienda;
    private String nombre;
    private double precio;
    private String rutaImagen;

    public Tienda(String nombre, double precio, String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
    }

    public Tienda() {
    }
    
    
}
