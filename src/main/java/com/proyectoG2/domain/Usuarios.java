package com.proyectoG2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NotEmpty
    private String nombreUsuario;
    @NotEmpty
    private String correoElectronico;
    @NotEmpty
    private String contraseña;
    private String telefono;
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles",joinColumns = @JoinColumn(name = "id_usuarios",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "id_rol",referencedColumnName = "id"))
    private Collection<Rol>roles;

    public Usuarios() {
    }

    public Usuarios(String nombreUsuario, String correoElectronico, String contraseña, String telefono, Collection<Rol> roles) {
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.roles = roles;
    }
    
}
