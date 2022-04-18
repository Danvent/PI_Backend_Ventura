package com.proyect.deparment.repository;

import com.proyect.deparment.entity.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<Vehicle,Integer>{
    
}
