package com.proyect.deparment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.User;
import com.proyect.deparment.service.UserService;

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
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService service;
    
    @GetMapping
    @ResponseBody
    private ResponseEntity<List<User>> listarUsuarios(){
        List<User> lista = service.listUsers();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    private ResponseEntity<HashMap<String,Object>> insertarUsuario(@RequestBody User obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            obj.setIdUser(0);
            User objSalida = service.miUser(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error en el registro comuniquese con el administrador de sistema");
            } else {
                salida.put("mensaje", "El usuario " + obj.getUsername() + " fue registrado correctamente");
            }
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar el usuario");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> actualizarUsuario(@RequestBody User obj){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        try {
            User objSalida = service.miUser(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error al actualizar la categoria, comunicarse con el administrador");
            } else {
                salida.put("mensaje", "Se actualizo la categoria :" + obj.getUsername() + "correctamente");
            }
        } catch (Exception e) {
            salida.put("Mensaje", "Error al actualizar la categoria");
        }
        return ResponseEntity.ok(salida);
    }

    
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> eliminarUsuario(@PathVariable("id") int IdUser){
        HashMap<String,Object> salida = new HashMap<String,Object>();
        Optional<User> optional = service.findUser(IdUser);
        if (optional.isPresent()) {
            service.deleteUser(IdUser);;
            salida.put("mensaje", "El usuario : " + optional.get().getUsername() + " fue eliminada");
        } else {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }


}
