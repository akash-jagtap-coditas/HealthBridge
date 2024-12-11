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
public class Taluka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long talukaId;

    private String name;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @OneToMany(mappedBy = "taluka")
    private Set<Users> users;

    @OneToMany(mappedBy = "taluka")
    private Set<City> cities;

    @OneToMany(mappedBy = "taluka")
    private Set<Facility> facilities;

}
