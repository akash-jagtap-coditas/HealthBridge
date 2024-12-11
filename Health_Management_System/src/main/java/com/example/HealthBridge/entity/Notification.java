package com.example.HealthBridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private String email;

    private LocalDateTime timestamp;

    private boolean isDeleted;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    private String message;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

}
