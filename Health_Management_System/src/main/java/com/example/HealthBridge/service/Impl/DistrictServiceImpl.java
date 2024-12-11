package com.example.HealthBridge.service.Impl;

import com.example.HealthBridge.dto.*;
import com.example.HealthBridge.entity.District;
import com.example.HealthBridge.entity.State;
import com.example.HealthBridge.repository.DistrictRepository;
import com.example.HealthBridge.repository.StateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImpl {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseDistrictDto createDistrict(DistrictDto districtDto){
        districtDto.setName(districtDto.getName().toUpperCase());
        Optional<State> existingState = stateRepository.findById(districtDto.getStateId());
        Optional<District> existingDistrict = districtRepository.findByName(districtDto.getName());
        if(existingDistrict.isPresent()){
            State state = existingDistrict.get().getState();
            if(state == existingState.get()){
                throw new RuntimeException("District already exists in this state.");
            }
        }
        District district = new District();
        district.setName(districtDto.getName());
        district.setState(existingState.get());
        ResponseDistrictDto districtDtoResponse =  objectMapper.convertValue(districtRepository.save(district),ResponseDistrictDto.class);
        districtDtoResponse.setState(objectMapper.convertValue(existingState.get(), ResponseStateDto.class));
        return districtDtoResponse;
    }

    public List<DistrictDtoResponse> getAllDistrictsInState(Long id){
        List<District> districtList = districtRepository.findAllDistrictsInState(id);
        return districtList.stream()
                .map(district ->
                        new DistrictDtoResponse(district.getDistrictId(), district.getName()))
                .collect(Collectors.toList());
    }
}
