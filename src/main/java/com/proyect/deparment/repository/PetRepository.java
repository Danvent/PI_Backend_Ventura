package com.proyect.deparment.repository;

import com.proyect.deparment.entity.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Integer> {
    
}
