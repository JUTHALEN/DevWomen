package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Bootcamp;

public interface BootcampService {
    public List<Bootcamp> findAll(); //Busca todo
    public Bootcamp findById(int idBootcamp); //Busca por Id
    public void deleteById(int idBootcamp); //Borra
    public void save (Bootcamp bootcamp); //Guarda y actualiza
    public void delete(Bootcamp bootcamp);
}
