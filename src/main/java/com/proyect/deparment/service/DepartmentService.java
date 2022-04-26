package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Department;

public interface DepartmentService {
    
    public abstract List<Department> listDeparments();

    public abstract Department miDeparment(Department obj);

    public abstract Optional<Department> findbyId(int IdDepartment);

    public abstract void deleteDeparment(int IdDepartment);

    // public abstract Optional<Department> findAllbyIdCategory(int IdCategory);
}
