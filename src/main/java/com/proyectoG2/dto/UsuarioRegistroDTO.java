package com.proyectoG2.dto;


public class UsuarioRegistroDTO {
    
    private Long id;
    private String nombreUsuario;
    private String correoElectronico;
    private String contraseña;
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public UsuarioRegistroDTO() {
    }

    public UsuarioRegistroDTO(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public UsuarioRegistroDTO(String nombreUsuario, String correoElectronico, String contraseña, String telefono) {
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;
    } 
}
