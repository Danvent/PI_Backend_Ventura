package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Customer;
import com.proyect.deparment.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> listCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findByIdCustomer(int idcostumer) {
        return repository.findById(idcostumer);
    }

    @Override
    public Customer miCustomer(Customer obj) {
        return repository.save(obj);
    }

    @Override
    public void deleteCustomer(int idcostumer) {
        repository.deleteById(idcostumer);
    }

    @Override
    public List<Customer> listCustomer(String documento) {
        return repository.findByDocumento(documento);
    }
}
