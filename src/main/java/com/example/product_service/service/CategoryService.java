package com.example.product_service.service;

import com.example.product_service.dto.CategoryDto;
import com.example.product_service.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> allCategory();
    public CategoryDto getCategoryDto(Long id);
    public Category addCategory(CategoryDto categoryDto);
    public Category updateCategory(Category category);
    public void deleteCategory(Long id);

    public Category readCategory(Long id);

}
