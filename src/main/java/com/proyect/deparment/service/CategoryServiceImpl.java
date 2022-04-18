package com.proyect.deparment.service;

import java.util.List;

import com.proyect.deparment.entity.Category;
import com.proyect.deparment.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> listCategories() {
        return repository.findAll();
    }

    @Override
    public Category miCategory(Category obj) {
        return repository.save(obj);
    }

    @Override
    public void deleteCategory(int IdCategory) {
        repository.deleteById(IdCategory);
    }
}
