package com.proyect.deparment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Customer;
import com.proyect.deparment.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/customer")
public class CustomerController {
    

    @Autowired
    private CustomerService service;

    
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Customer>> listarClientes(){
        List<Customer> lista = service.listCustomers();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> insertarCliente(@RequestBody Customer obj){
        HashMap<String, Object> salida = new HashMap<String, Object>();
        try {
            List<Customer> lstCustomer = service.listCustomer(obj.getDocumento());
            if (CollectionUtils.isEmpty(lstCustomer)) {
                obj.setIdcustomer(0);
                service.miCustomer(obj);
                salida.put("mensaje", "El cliente " + obj.getNombre() + ' ' + obj.getApellidoP() + obj.getApellidoM() + " se registro correctamente");
            } else {
                salida.put("mensaje", "El cliente con " + obj.getDocumento() + " ya existe.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", obj);
        }
        return ResponseEntity.ok(salida);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> eliminarClient(@PathVariable("id") int idcustomer){
        HashMap<String, Object> salida = new HashMap<String, Object>();
        Optional<Customer> optional = service.findByIdCustomer(idcustomer);
        if (optional.isPresent()) {
            service.deleteCustomer(idcustomer);
            salida.put("mensaje", "Se eliminó el Cliente : " + optional.get().getNombre() + " correctamente ");
        } else {
            salida.put("mensaje", "Error al eliminar el cliente");
        }
        return ResponseEntity.ok(salida);
    }

}
