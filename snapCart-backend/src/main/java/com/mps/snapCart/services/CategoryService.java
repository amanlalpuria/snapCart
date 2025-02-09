package com.mps.snapCart.services;

import com.mps.snapCart.entities.Category;
import com.mps.snapCart.exceptions.CategoryNotFoundException;
import com.mps.snapCart.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + id));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Integer id, Category categoryDetails) {
        Category category = getCategoryById(id);
        category.setCategoryName(categoryDetails.getCategoryName());
        category.setDescription(categoryDetails.getDescription());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }
}