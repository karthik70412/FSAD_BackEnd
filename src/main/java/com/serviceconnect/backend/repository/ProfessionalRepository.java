package com.serviceconnect.backend.repository;

import com.serviceconnect.backend.entity.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findByCategoryId(Long categoryId);
    Optional<Professional> findByEmail(String email);
}