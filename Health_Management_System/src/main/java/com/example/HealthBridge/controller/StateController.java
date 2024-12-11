package com.example.HealthBridge.controller;

import com.example.HealthBridge.dto.ApiResponse;
import com.example.HealthBridge.dto.ResponseStateDto;
import com.example.HealthBridge.dto.StateDto;
import com.example.HealthBridge.service.Impl.StateServiceImpl;
import com.example.HealthBridge.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("healthbridge/state")
public class StateController {

    @Autowired
    StateServiceImpl stateService;

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<ResponseStateDto>> createState(@RequestBody StateDto stateDto){
        return ResponseUtil.success(stateService.createState(stateDto),"State created successfully.");
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ResponseStateDto>> getState(@PathVariable Long id) throws IOException {
        return ResponseUtil.success(stateService.getState(id),"State retrieved successfully.");
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<ResponseStateDto>>> getAllStates(){
        return ResponseUtil.success(stateService.getAllStates(),"All states retreived successfully");
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ResponseStateDto>> updateState(@RequestBody StateDto stateDto,@PathVariable Long id){
        return ResponseUtil.success(stateService.updateState(stateDto,id),"State updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteState(@PathVariable Long id){
        stateService.deleteState(id);
        return ResponseUtil.delete("State deleted successfully.");
    }


}
