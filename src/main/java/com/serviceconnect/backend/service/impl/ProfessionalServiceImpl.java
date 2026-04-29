package com.serviceconnect.backend.service.impl;

import com.serviceconnect.backend.entity.Professional;
import com.serviceconnect.backend.repository.ProfessionalRepository;
import com.serviceconnect.backend.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalRepository professionalRepository;

    @Override
    public List<Professional> getAllProfessionals() {
        return professionalRepository.findAll();
    }

    @Override
    public Professional getProfessionalById(Long id) {
        return professionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professional not found"));
    }

    @Override
    public List<Professional> getByCategory(Long categoryId) {
        return professionalRepository.findByCategoryId(categoryId);
    }
}