package com.example.product_service.service;

import com.example.product_service.dto.CategoryDto;
import com.example.product_service.entity.Category;
import com.example.product_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDto getCategoryDto(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found - " + id));
        return CategoryDto.builder()
                .name(category.getName())
                .build();
    }

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        return categoryRepository.save(Category.builder()
                .name(categoryDto.getName())
                .build());
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category readCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found - " + id));
    }
}
