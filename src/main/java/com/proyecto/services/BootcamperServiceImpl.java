package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.dao.BootcamperDao;
import com.proyecto.entities.Bootcamper;

@Service
public class BootcamperServiceImpl implements BootcamperService {


    @Autowired
    private BootcamperDao bootcamperDao;

    @Override
    public List<Bootcamper> findAll() {
       return bootcamperDao.findAll();
    }

    @Override
    public Bootcamper findById(int idBootcamper) {
        return bootcamperDao.findById(idBootcamper).get();
    }

    @Override
    @Transactional
    public void deleteById(int idBootcamper) {
        bootcamperDao.deleteById(idBootcamper);
    }

    @Override
    @Transactional
    public void save(Bootcamper bootcamper) {
       bootcamperDao.save(bootcamper);
    }

    @Override
    @Transactional
    public void delete(Bootcamper bootcamper) {
        bootcamperDao.delete(bootcamper);
    }
}


