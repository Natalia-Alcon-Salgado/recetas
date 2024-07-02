package org.proyect.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String instrucciones;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "receta")
    private List<Ingrediente> ingredientes;

    // Constructores
    public Receta() {
    }

    public Receta(String nombre, String descripcion, String instrucciones, Categoria categoria,
            List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instrucciones = instrucciones;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
    }
}