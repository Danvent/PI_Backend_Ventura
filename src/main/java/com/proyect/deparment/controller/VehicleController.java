package com.proyect.deparment.controller;

import java.util.List;

import com.proyect.deparment.entity.Vehicle;
import com.proyect.deparment.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;


    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Vehicle>> listarVehiculos(){
        List<Vehicle> lista = service.listarVehiculos();
        return ResponseEntity.ok(lista);
    }
    
}
