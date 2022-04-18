package com.proyect.deparment.controller;

import java.util.HashMap;
import java.util.List;

import com.proyect.deparment.entity.Department;
import com.proyect.deparment.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Department>> listarDepartamento(){
        List<Department> lista = service.listDeparments();
        return ResponseEntity.ok(lista);
    }
     
    @PostMapping
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> registrarDepartamento(@RequestBody Department obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            obj.setIdDepartment(0);
            service.miDeparment(obj);
            salida.put("mensaje", "El departamento fue registrado con exito");
            
        } catch (Exception e) {
            //TODO: handle exception
            salida.put("mensaje", "Error al registrar el departamento" + obj.getDescripcion() + obj.getNumero() + obj.getPiso() + obj.getCategory());
        }
        return ResponseEntity.ok(salida);
    }
}
