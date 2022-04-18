package com.proyect.deparment.service;

import java.util.List;

import com.proyect.deparment.entity.Vehicle;
import com.proyect.deparment.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    
    @Autowired
    private VehicleRepository repository;

    @Override
    public List<Vehicle> listarVehiculos() {
        return repository.findAll();
    }
}
