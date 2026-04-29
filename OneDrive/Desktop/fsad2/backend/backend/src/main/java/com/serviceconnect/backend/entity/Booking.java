package com.serviceconnect.backend.entity;

import com.serviceconnect.backend.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime serviceDate;

    private String address;
    private String notes;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Professional professional;
}