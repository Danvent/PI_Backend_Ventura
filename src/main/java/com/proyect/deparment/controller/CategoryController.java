package com.proyect.deparment.controller;

import java.util.HashMap;
import java.util.List;

import com.proyect.deparment.entity.Category;
import com.proyect.deparment.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/category")
public class CategoryController {
    
    @Autowired
    private CategoryService service;

    @GetMapping
    @ResponseBody
    private ResponseEntity<List<Category>> listarCategorias(){
        List<Category> lista = service.listCategories();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    private ResponseEntity<HashMap<String,Object>> insertarCategoria(@RequestBody Category obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            obj.setIdCategory(0);
            service.miCategory(obj);
            salida.put("mensaje", "La categoria fue registrada exitosamente");
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar la categoria");
        }
        return ResponseEntity.ok(salida);

    }

}
