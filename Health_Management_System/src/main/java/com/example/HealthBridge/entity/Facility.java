package com.example.HealthBridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityId;

    private String name;

    private String type;

    @Column(name = "abha_id")
    private String abhaId;

    private boolean isDeleted;

    @OneToOne(mappedBy = "facility", cascade = CascadeType.ALL)
    private ApprovalStatus approvalStatus;

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
    @JoinColumn(name = "city_id", nullable = true)
    private City city;

    @ManyToOne
    @JoinColumn(name = "data_collector_id", nullable = false)
    private Users dataCollector;

    // Getters and setters
}
