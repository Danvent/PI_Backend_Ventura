package com.proyect.deparment.controller;

import java.util.List;

import com.proyect.deparment.entity.Pet;
import com.proyect.deparment.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/pet")
public class PetController {
  
    @Autowired
    private PetService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Pet>> listarMascotas(){
        List<Pet> lista = service.listaMascota();
        return ResponseEntity.ok(lista);
    }
    
}
