package com.example.HealthBridge.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @Column(unique = true)
    private String name;

    private boolean isDeleted;

    @OneToMany(mappedBy = "state")
    private Set<Users> users;

    @JsonBackReference
    @OneToMany(mappedBy = "state")
    private Set<District> districts;
}
