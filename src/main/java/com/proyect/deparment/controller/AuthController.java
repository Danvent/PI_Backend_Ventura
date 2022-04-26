package com.proyect.deparment.controller;

import java.util.HashMap;
import java.util.List;

import com.proyect.deparment.entity.User;
import com.proyect.deparment.service.UserService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class AuthController {
    
    @Autowired
    private UserService service;

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<?> auth(@RequestBody User obj){
        List<User> lista = service.validateUser(obj.getUsername(), obj.getPassword());
        HashMap<String,Object> salida = new HashMap<String, Object>();
        if(lista.isEmpty()){
            salida.put("mensaje", "usuario o contraseña incorrectos");
            return ResponseEntity.badRequest().body(salida);   
        }
        return ResponseEntity.ok(lista);
    }


}
