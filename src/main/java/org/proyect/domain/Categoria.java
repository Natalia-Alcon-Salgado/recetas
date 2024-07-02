package org.proyect.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        @OneToMany(mappedBy = "categoria")
        private List<Receta> recetas;

        // Constructores
        public Categoria() {
        }

        public Categoria(String nombre, List <Receta> recetas) {
            this.nombre = nombre;
            this.recetas = recetas;
        }
    }