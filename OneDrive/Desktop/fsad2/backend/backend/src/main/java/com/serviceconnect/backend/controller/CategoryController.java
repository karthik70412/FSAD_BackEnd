package com.serviceconnect.backend.controller;

import com.serviceconnect.backend.dto.CategoryRequest;
import com.serviceconnect.backend.entity.Category;
import com.serviceconnect.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category addCategory(@RequestBody CategoryRequest request) {
        return categoryService.addCategory(request);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }
}