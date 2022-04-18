package com.proyect.deparment.service;

import java.util.List;

import com.proyect.deparment.entity.Department;

public interface DepartmentService {
    
    public abstract List<Department> listDeparments();

    public abstract Department miDeparment(Department obj);

    public abstract void deleteDeparment(int IdDepartment);
}
