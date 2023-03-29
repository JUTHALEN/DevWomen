package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Bootcamp;

@Repository
public interface BootcampDao extends JpaRepository<Bootcamp, Integer> {
    
}
