package com.example.HealthBridge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {

    private Long stateId;
    private String name;

    private boolean isDeleted;
}
