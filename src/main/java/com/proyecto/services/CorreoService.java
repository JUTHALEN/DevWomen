package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Bootcamper;
import com.proyecto.entities.Correo;

public interface CorreoService {
    public List<Correo> findAll(); 
    public Correo findById(int idCorreo); 
    public void deleteById(int idCorreo); 
    public void save (Correo correo); 
    public void deleteByBootcamper (Bootcamper bootcamper);
    public List<Correo> findByBootcamper(Bootcamper bootcamper);
}
