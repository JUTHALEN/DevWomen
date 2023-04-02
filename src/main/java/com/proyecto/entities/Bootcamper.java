package com.proyecto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bootcampers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Bootcamper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private double salario;
    
    private Formacion formacion;
    private String foto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;  


    public enum Formacion {
         GRADO_UNIVERSITARIO, GRADO_SUPERIOR, GRADO_MEDIO, BACHILLERATO;
    }

    /**
     * Creación de relaciones entre tablas
     */
    
 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
 @JoinColumn(name = "idBootcamp")

 private Bootcamp bootcamp;


 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "bootcamper")
 private List<Telefono> telefonos;

 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "bootcamper")
private List<Correo> correos;

@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "bootcamper")
private List<Idioma> idiomas;
}

