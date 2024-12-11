package com.example.HealthBridge.controller;

import com.example.HealthBridge.dto.ApiResponse;
import com.example.HealthBridge.dto.DistrictDto;
import com.example.HealthBridge.dto.DistrictDtoResponse;
import com.example.HealthBridge.dto.ResponseDistrictDto;
import com.example.HealthBridge.repository.DistrictRepository;
import com.example.HealthBridge.service.Impl.DistrictServiceImpl;
import com.example.HealthBridge.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("healthbridge/district")
public class DistrictController {

    @Autowired
    DistrictServiceImpl districtService;

    @PostMapping
    public ResponseEntity<ApiResponse<ResponseDistrictDto>> createDistrict(@RequestBody DistrictDto districtDto, @RequestParam Long stateId){
        districtDto.setStateId(stateId);
        ResponseDistrictDto responseDistrictDto = districtService.createDistrict(districtDto);
       return ResponseUtil.success(responseDistrictDto,"District created successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<DistrictDtoResponse>>> getAllDistrictsInState(@PathVariable Long id){
        List<DistrictDtoResponse> districtDtoResponseList = districtService.getAllDistrictsInState(id);
        return ResponseUtil.success(districtDtoResponseList,"All districts in state retrieved successfully.");
    }
}
