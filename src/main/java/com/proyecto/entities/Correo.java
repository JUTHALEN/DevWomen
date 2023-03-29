package com.proyecto.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "correos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Correo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 


    private int id;
    private String email;

    /**
     * Creación de relaciones entre tablas
     */

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Bootcamper bootcamper;
}
