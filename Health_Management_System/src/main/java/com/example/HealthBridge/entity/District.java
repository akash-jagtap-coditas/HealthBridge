package com.example.HealthBridge.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;

    @Column(nullable = false)
    private String name;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    @JsonManagedReference
    private State state;

    @OneToMany(mappedBy = "district")
    private Set<Users> users;

    @OneToMany(mappedBy = "district")
    private Set<Taluka> talukas;

    @OneToMany(mappedBy = "district")
    private Set<Facility> facilities;

}
