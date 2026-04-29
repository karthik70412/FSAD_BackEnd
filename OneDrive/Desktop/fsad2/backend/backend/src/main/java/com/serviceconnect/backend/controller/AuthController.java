package com.serviceconnect.backend.controller;

import com.serviceconnect.backend.dto.*;
import com.serviceconnect.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register-professional")
    public String registerProfessional(@RequestBody ProfessionalRegisterRequest request) {
        return authService.registerProfessional(request);
    }
}