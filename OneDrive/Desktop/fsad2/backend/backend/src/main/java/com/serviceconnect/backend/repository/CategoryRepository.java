package com.serviceconnect.backend.repository;

import com.serviceconnect.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}