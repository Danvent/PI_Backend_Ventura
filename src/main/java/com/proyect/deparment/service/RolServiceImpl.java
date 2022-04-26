package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Rol;
import com.proyect.deparment.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {
    
    @Autowired
    private RolRepository repository;

    @Override
    public List<Rol> listRols() {
        return repository.findAll();
    }

    @Override
    public Optional<Rol> findRol(int IdRol) {
        return repository.findById(IdRol);
    }

    @Override
    public Rol miRol(Rol obj) {
        return repository.save(obj);
    }

    @Override
    public void deleteRol(int IdRol) {
         repository.deleteById(IdRol);
    }
}
