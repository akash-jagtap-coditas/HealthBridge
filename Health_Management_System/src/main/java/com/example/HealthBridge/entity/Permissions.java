package com.example.HealthBridge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    private String name;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
