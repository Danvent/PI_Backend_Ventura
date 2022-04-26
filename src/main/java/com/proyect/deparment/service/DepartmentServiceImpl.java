package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Department;
import com.proyect.deparment.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl  implements DepartmentService{
    
    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> listDeparments() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }
    @Override
    public Optional<Department> findbyId(int IdDepartment) {
        return repository.findById(IdDepartment);
    }

    @Override
    public Department miDeparment(Department obj) {
        // TODO Auto-generated method stub
        return repository.save(obj);
    }

    @Override
    public void deleteDeparment(int IdDepartment) {
        // TODO Auto-generated method stub
        repository.deleteById(IdDepartment);
    }

    // @Override
    // public Optional<Department> findAllbyIdCategory(int IdCategory) {
    //     return repository.findAllBycategory(IdCategory);
    // }
}
