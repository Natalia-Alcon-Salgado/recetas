package org.proyect.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable( name = "usuario_receta_favorita", joinColumns = @JoinColumn(name = "usuario_id"),    inverseJoinColumns = @JoinColumn(name = "receta_id"))

    private List <Receta> recetasFav;
    private Boolean estaRegistrado;
    private Boolean esAdmin;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Rol> roles;

    // Constructores
    public Usuario() {
    }

    public Usuario(List<Receta> recetasFav, Boolean estaRegistrado, Boolean esAdmin, Persona persona, List<Rol> roles) {
        this.recetasFav = recetasFav;
        this.estaRegistrado = estaRegistrado;
        this.esAdmin = esAdmin;
        this.persona = persona;
        this.roles = roles;
    }
}