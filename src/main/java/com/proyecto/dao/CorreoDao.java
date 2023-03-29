package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Bootcamper;
import com.proyecto.entities.Correo;

@Repository
public interface CorreoDao extends JpaRepository <Correo,Integer> {


    long deleteByBootcamper (Bootcamper bootcamper);
    
    List <Correo> findByBootcamper (Bootcamper bootcamper);
    
}
