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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String name;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "taluka_id", nullable = false)
    private Taluka taluka;

    @OneToMany(mappedBy = "city")
    private Set<Users> users;

    @OneToMany(mappedBy = "city")
    private Set<Facility> facilities;

}
