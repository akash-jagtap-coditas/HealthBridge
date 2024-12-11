package com.example.HealthBridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String username;
    private String password;
    private String phoneNo;

    private boolean isDeleted;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private RefreshToken refreshToken;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = true)
    private State state;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = true)
    private District district;

    @ManyToOne
    @JoinColumn(name = "taluka_id", nullable = true)
    private Taluka taluka;

    @ManyToOne
    @JoinColumn(name = "city_id",nullable = true)
    private City city;

    @ManyToOne
    @JoinColumn(name = "reporting_admin_id", nullable = true, referencedColumnName = "userId")
    private Users reportingAdmin;

    @OneToMany(mappedBy = "dataCollector")
    private Set<Facility> facilities;

    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "approvedBy")
    private Set<ApprovalStatus> approvals;

    @OneToMany(mappedBy = "rejectedBy")
    private Set<ApprovalStatus> rejections;

}
