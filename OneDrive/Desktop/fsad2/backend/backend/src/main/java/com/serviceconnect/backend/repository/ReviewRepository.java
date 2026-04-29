package com.serviceconnect.backend.repository;

import com.serviceconnect.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProfessionalId(Long professionalId);
}