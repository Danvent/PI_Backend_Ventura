package com.proyect.deparment.repository;

import com.proyect.deparment.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
