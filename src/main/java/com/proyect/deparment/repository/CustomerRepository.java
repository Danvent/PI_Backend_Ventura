package com.proyect.deparment.repository;

import com.proyect.deparment.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface CustomerRepository extends JpaRepository<Customer,Integer>{

 public abstract List<Customer> findByDocumento(String documento);

}  
