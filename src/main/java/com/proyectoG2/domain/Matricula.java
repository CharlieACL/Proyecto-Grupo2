
package com.proyectoG2.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity 
@Table(name="matricula") 
public class Matricula implements Serializable {
    
    private static final long serialVersionUID = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_matricula")
    private Long idMatricula;
    @Column(name ="identificacion_estudiante")
    private int identificacionEstudiante;
    @Column(name ="nombre_completo_estudiante")
    private String nombreCompletoEstudiante;
    private int dia;
    private int mes;
    private int aho;
    @Column(name ="lugar_nacimiento")
    private String lugarNacimiento;
    @Column(name ="ahos_cumplidos")
    private int ahosCumplidos;
    @Column(name ="direccion_calle_principal")
    private String direccionCallePrincipal;
    @Column(name ="telefono_convencional")
    private int telefonoConvencional;
    @Column(name ="direccion_calle_transversal")
    private String direccionCalleTransversal;
    @Column(name ="numero_casa")
    private int numeroCasa;
    private String sede;
    @Column(name ="identificacion_encargado")
    private int identificacionEncargado;
    @Column(name="nombre_completo_encargado")
    private String nombreCompletoEncargado;
    private int telefono;

    public Matricula() {
    }

    public Matricula(String nombreCompletoEstudiante, int dia, int mes, int aho, String lugarNacimiento, int ahosCumplidos, String direccionCallePrincipal, int telefonoConvencional, String direccionCalleTransversal, int numeroCasa, String sede, int identificacionEncargado, String nombreCompletoEncargado, int telefono) {
        this.nombreCompletoEstudiante = nombreCompletoEstudiante;
        this.dia = dia;
        this.mes = mes;
        this.aho = aho;
        this.lugarNacimiento = lugarNacimiento;
        this.ahosCumplidos = ahosCumplidos;
        this.direccionCallePrincipal = direccionCallePrincipal;
        this.telefonoConvencional = telefonoConvencional;
        this.direccionCalleTransversal = direccionCalleTransversal;
        this.numeroCasa = numeroCasa;
        this.sede = sede;
        this.identificacionEncargado = identificacionEncargado;
        this.nombreCompletoEncargado = nombreCompletoEncargado;
        this.telefono = telefono;
    }

    

    
    
    
    
}
