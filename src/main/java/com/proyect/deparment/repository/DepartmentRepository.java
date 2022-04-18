package com.proyect.deparment.repository;

import com.proyect.deparment.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    
}
