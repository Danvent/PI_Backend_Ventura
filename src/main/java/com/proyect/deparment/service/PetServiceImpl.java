package com.proyect.deparment.service;

import java.util.List;

import com.proyect.deparment.entity.Pet;
import com.proyect.deparment.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {
    
    @Autowired
    private PetRepository repository;

    @Override
    public List<Pet> listaMascota() {
        return repository.findAll();
    }

    @Override
    public void deletePets(int idcostumer) {
        repository.deleteById(idcostumer);
    }
}
