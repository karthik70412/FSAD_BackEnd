package com.serviceconnect.backend.service.impl;

import com.serviceconnect.backend.dto.*;
import com.serviceconnect.backend.entity.Category;
import com.serviceconnect.backend.entity.Professional;
import com.serviceconnect.backend.entity.User;
import com.serviceconnect.backend.enums.Role;
import com.serviceconnect.backend.repository.CategoryRepository;
import com.serviceconnect.backend.repository.ProfessionalRepository;
import com.serviceconnect.backend.repository.UserRepository;
import com.serviceconnect.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ProfessionalRepository professionalRepository;
    private final CategoryRepository categoryRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        var userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return new AuthResponse("dummy-token", user.getRole().name(), user.getFullName(), user.getId());
            }
        }

        var proOpt = professionalRepository.findByEmail(request.getEmail());
        if (proOpt.isPresent()) {
            Professional pro = proOpt.get();
            if (passwordEncoder.matches(request.getPassword(), pro.getPassword())) {
                return new AuthResponse("dummy-token", "PROFESSIONAL", pro.getFullName(), pro.getId());
            }
        }

        throw new RuntimeException("Invalid email or password");
    }

    @Override
    public String registerProfessional(ProfessionalRegisterRequest request) {
        if (professionalRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Professional professional = Professional.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .location(request.getLocation())
                .hourlyRate(request.getHourlyRate())
                .bio(request.getBio())
                .category(category)
                .rating(0.0)
                .totalReviews(0)
                .build();

        professionalRepository.save(professional);
        return "Professional registered successfully";
    }
}