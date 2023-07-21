package com.proyectoG2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String correo;
    private String telefono;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(String username, String password, String correo, String telefono, boolean activo, List<Rol> roles) {
        this.username = username;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.activo = activo;
        this.roles = roles;
    }

    
}
