package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Bootcamper;
import com.proyecto.entities.Telefono;

@Repository
public interface TelefonoDao extends JpaRepository <Telefono, Integer> {

    long deleteByBootcamper (Bootcamper bootcamper);
    
    List <Telefono> findByBootcamper (Bootcamper bootcamper);
    
}
