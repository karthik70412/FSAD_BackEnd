package com.serviceconnect.backend.service;

import com.serviceconnect.backend.dto.CategoryRequest;
import com.serviceconnect.backend.entity.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(CategoryRequest request);
    List<Category> getAllCategories();
    void deleteCategory(Long id);
}