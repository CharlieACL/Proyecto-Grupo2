
package com.proyectoG2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_producto")
    private Long idProducto;
    private String descripcion;
    private double precio;
    private int existencias; 
    private String rutaImagen;
    
    @ManyToOne
    @JoinColumn (name = "id_tienda") 
    private Tienda tienda;

    public Producto(String descripcion, String detalle, double precio, int existencias, String rutaImagen, boolean activo, Tienda tienda) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
        this.tienda = tienda;
    }

    public Producto() {
    }
      
}
