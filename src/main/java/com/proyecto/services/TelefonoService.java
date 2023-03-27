package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Bootcamper;
import com.proyecto.entities.Telefono;

public interface TelefonoService {
    public List<Telefono> findAll(); //Busca todo
    public Telefono findById(int idTelefono); //Busca por Id
    public void deleteById(int idTelefono); //Borra
    public void save (Telefono telefono); //Guarda y actualiza
    public void deleteByBootcamper (Bootcamper bootcamper);
    public List<Telefono> findByBootcamper(Bootcamper bootcamper);
}
