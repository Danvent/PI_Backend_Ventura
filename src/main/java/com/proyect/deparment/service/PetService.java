package com.proyect.deparment.service;

import java.util.List;

import com.proyect.deparment.entity.Pet;

public interface PetService {
    
    public abstract List<Pet> listaMascota();

    public abstract void deletePets(int IdCustomer);
}
