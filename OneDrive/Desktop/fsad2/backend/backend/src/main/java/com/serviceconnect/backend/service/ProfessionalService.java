package com.serviceconnect.backend.service;

import com.serviceconnect.backend.entity.Professional;

import java.util.List;

public interface ProfessionalService {
    List<Professional> getAllProfessionals();
    Professional getProfessionalById(Long id);
    List<Professional> getByCategory(Long categoryId);
}