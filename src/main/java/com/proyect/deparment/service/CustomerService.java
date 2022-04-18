package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Customer;

public interface CustomerService {
    
    public abstract List<Customer> listCustomers();

	public abstract Customer miCustomer(Customer obj);

    public abstract List<Customer> listCustomer(String  documento);

    public abstract Optional<Customer> findByIdCustomer(int idcustomer);

    public abstract void deleteCustomer(int idcustomer);
}
