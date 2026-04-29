package com.serviceconnect.backend.dto;

import lombok.Data;

@Data
public class ProfessionalRegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private Long categoryId;
    private String location;
    private Double hourlyRate;
    private String bio;
}