package org.proyect.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String contraseña;
    private String correo;

    @OneToOne(mappedBy = "persona")
    private Usuario usuario;

    // Constructores
    public Persona() {
    }

    public Persona(String nombre, String contraseña, String correo, Usuario usuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.usuario = usuario;
    }
}