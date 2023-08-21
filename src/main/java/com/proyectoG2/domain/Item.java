package com.proyectoG2.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class Item extends Tienda {
    private int cantidad; 

    public Item() {
    }

    public Item(Tienda tienda) {
        super.setIdTienda(tienda.getIdTienda());
        super.setNombre(tienda.getNombre());
        super.setPrecio(tienda.getPrecio());
        super.setRutaImagen(tienda.getRutaImagen());
        this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
