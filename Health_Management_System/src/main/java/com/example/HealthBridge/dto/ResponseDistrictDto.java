package com.example.HealthBridge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDistrictDto {

    private long districtId;
    private String name;
    private ResponseStateDto state;
}
