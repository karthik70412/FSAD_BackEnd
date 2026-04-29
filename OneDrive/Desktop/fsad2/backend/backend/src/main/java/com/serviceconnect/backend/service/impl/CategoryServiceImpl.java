package com.serviceconnect.backend.service.impl;

import com.serviceconnect.backend.dto.CategoryRequest;
import com.serviceconnect.backend.entity.Category;
import com.serviceconnect.backend.repository.CategoryRepository;
import com.serviceconnect.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryRequest request) {
        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}