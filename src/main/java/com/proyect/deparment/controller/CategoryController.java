package com.proyect.deparment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


import com.proyect.deparment.entity.Category;
import com.proyect.deparment.entity.Department;
import com.proyect.deparment.service.CategoryService;
import com.proyect.deparment.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Autowired
    private DepartmentService serviceDepartment;

    @GetMapping
    @ResponseBody
    private ResponseEntity<List<Category>> listarCategorias(){
        List<Category> lista = service.listCategories();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    @ResponseBody
    private ResponseEntity<Optional<Category>> listarCategoriaId(@PathVariable("id") int idCategory){
        Optional<Category> lista = service.findbyId(idCategory);
        return ResponseEntity.ok(lista);

    }

    @PostMapping
    @ResponseBody
    private ResponseEntity<HashMap<String,Object>> insertarCategoria(@RequestBody Category obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            obj.setIdCategory(0);
            Category objSalida = service.miCategory(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error en el registro comuniquese con el administrador de sistema");
            } else {
                salida.put("mensaje", "La categor??a " + obj.getDescripcion() + "fue registrado correctamente");
            }
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar la categoria");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> actualizarCategoria(@RequestBody Category obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            Category objSalida = service.miCategory(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error al actualizar la categoria, comunicarse con el administrador");
            } else {
                salida.put("mensaje", "Se actualizo la categoria :" + obj.getDescripcion() + "correctamente");
            }
        } catch (Exception e) {
            salida.put("Mensaje", "Error al actualizar la categoria");
        }
        return ResponseEntity.ok(salida);
    }

    
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> eliminarCategoria(@PathVariable("id") int idCategory){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        // Optional<Department> optionalValidate = serviceDepartment.findAllbyIdCategory(idCategory);
        Optional<Category> optional = service.findbyId(idCategory);
        if (optional.isPresent()) {
            // if(optionalValidate.isPresent()){
            //     salida.put("mensaje", "La categoria esta siendo usada y no se puede borrar");
            // } else {
                service.deleteCategory(idCategory);
                salida.put("mensaje", "La categoria : " + optional.get().getDescripcion() + " fue eliminada");
            // }
        } else {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

}
