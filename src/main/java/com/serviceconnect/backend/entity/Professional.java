package com.serviceconnect.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;

    private String location;
    private Double hourlyRate;

    @Column(length = 1000)
    private String bio;

    private Double rating = 0.0;
    private int totalReviews = 0;

    @ManyToOne
    private Category category;
}