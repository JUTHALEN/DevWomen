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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bootcamps")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Bootcamp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String nombre;

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;  

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;  


    /**
     * Creación de relaciones entre tablas
     */

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "bootcamp" ) 
    private List <Bootcamper> bootcampers;
    
}
