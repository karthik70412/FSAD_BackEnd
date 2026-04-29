package com.serviceconnect.backend.controller;

import com.serviceconnect.backend.entity.Professional;
import com.serviceconnect.backend.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ProfessionalController {

    private final ProfessionalService professionalService;

    @GetMapping
    public List<Professional> getAllProfessionals() {
        return professionalService.getAllProfessionals();
    }

    @GetMapping("/{id}")
    public Professional getProfessionalById(@PathVariable Long id) {
        return professionalService.getProfessionalById(id);
    }

    @GetMapping("/category/{id}")
    public List<Professional> getByCategory(@PathVariable Long id) {
        return professionalService.getByCategory(id);
    }
}