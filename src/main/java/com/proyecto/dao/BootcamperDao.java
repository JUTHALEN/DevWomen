package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Bootcamper;

@Repository
public interface BootcamperDao extends JpaRepository <Bootcamper,Integer> {
    
}
