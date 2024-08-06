package com.example.product_service.controller;

import com.example.product_service.dto.CategoryDto;
import com.example.product_service.entity.Category;
import com.example.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> readAllCategory(){
        return new ResponseEntity<>(categoryService.allCategory(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> readCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getCategoryDto(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.addCategory(categoryDto), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return HttpStatus.OK;
    }
}
