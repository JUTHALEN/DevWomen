package com.proyecto.services;

import java.util.List;

import com.proyecto.dao.BootcampDao;
import com.proyecto.entities.Bootcamp;

import jakarta.transaction.Transactional;

public class BootcampServiceImpl implements BootcampService {

    private BootcampDao bootcampDao;
    @Override
    public List<Bootcamp> findAll() {
        return bootcampDao.findAll();
    }

    @Override
    public Bootcamp findById(int idBootcamp) {
        return bootcampDao.findById(idBootcamp).get();
    }

    @Transactional
    @Override
    public void deleteById(int idBootcamp) {
        bootcampDao.deleteById(idBootcamp);
    }

    @Transactional
    @Override
    public void save(Bootcamp bootcamp) {
        bootcampDao.save(bootcamp);
    }

    @Override
    public void delete(Bootcamp bootcamp) {
        bootcampDao.delete(bootcamp);
    }
    
}
