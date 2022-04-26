package com.proyect.deparment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Rol;
import com.proyect.deparment.service.RolService;

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
@CrossOrigin( origins = "http://localhost:4200")
@RequestMapping("/rest/rol")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    @ResponseBody
    private ResponseEntity<List<Rol>> listarRoles(){
        List<Rol> lista = service.listRols();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    private ResponseEntity<HashMap<String,Object>> insertarRol(@RequestBody Rol obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            obj.setIdRol(0);
            Rol objSalida = service.miRol(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error en el registro comuniquese con el administrador de sistema");
            } else {
                salida.put("mensaje", "El rol " + obj.getDescripcion() + " fue registrado correctamente");
            }
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar el usuario");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> actualizarRol(@RequestBody Rol obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            Rol objSalida = service.miRol(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error al actualizar la categoria, comunicarse con el administrador");
            } else {
                salida.put("mensaje", "Se actualizo el rol :" + obj.getDescripcion() + "correctamente");
            }
        } catch (Exception e) {
            salida.put("Mensaje", "Error al actualizar la categoria");
        }
        return ResponseEntity.ok(salida);
    }

    
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> eliminarRol(@PathVariable("id") int IdRol){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        Optional<Rol> optional = service.findRol(IdRol);
        if (optional.isPresent()) {
            service.deleteRol(IdRol);
            salida.put("mensaje", "El Rol : " + optional.get().getDescripcion() + " fue eliminada");
        } else {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }
    


}
