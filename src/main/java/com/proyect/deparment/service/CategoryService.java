package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Category;

public interface CategoryService {

    public abstract List<Category> listCategories();

    public abstract Category miCategory(Category obj);

    public abstract void deleteCategory(int idCategory);

    public Optional<Category> findbyId(int idCategory);
    
}
