package com.serviceconnect.backend.service;

import com.serviceconnect.backend.dto.*;

public interface AuthService {
    String register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    String registerProfessional(ProfessionalRegisterRequest request);
}