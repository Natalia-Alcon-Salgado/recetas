package org.proyect.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cantidad;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    // Constructores
    public Ingrediente() {
    }

    public Ingrediente(String nombre, String cantidad, Receta receta) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.receta = receta;
    }
}