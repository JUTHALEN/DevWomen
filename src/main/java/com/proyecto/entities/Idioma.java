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
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "idiomas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Idioma implements Serializable{
    
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String nombre;

    private Nivel nivel;

    public enum Nivel {
        A1, A2, B1, B2, C1, C2
    }

    private String certificado;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Bootcamper bootcamper;

}
