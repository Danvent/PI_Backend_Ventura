package com.proyect.deparment.repository;


import com.proyect.deparment.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    

    // @Query("select p from Department p inner join Category c on p.IdCategory=c.IdCategory where p.IdCategory = ?1")
    // Optional<Department> findAllBycategory(int IdCategory);

}
