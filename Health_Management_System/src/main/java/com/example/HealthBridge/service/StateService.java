package com.example.HealthBridge.service;

import com.example.HealthBridge.dto.ResponseStateDto;
import com.example.HealthBridge.dto.StateDto;


import java.io.IOException;
import java.util.List;


public interface StateService {

    public ResponseStateDto createState(StateDto stateDto);

    public ResponseStateDto getState(Long id) throws IOException ;


    public List<ResponseStateDto> getAllStates();

    public ResponseStateDto updateState(StateDto stateDto,Long id);

    public void deleteState(Long id);

}
