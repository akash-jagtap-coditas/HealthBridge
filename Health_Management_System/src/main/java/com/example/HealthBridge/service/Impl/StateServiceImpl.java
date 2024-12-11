package com.example.HealthBridge.service.Impl;

import com.example.HealthBridge.dto.ResponseStateDto;
import com.example.HealthBridge.dto.StateDto;
import com.example.HealthBridge.entity.State;
import com.example.HealthBridge.exception.StateNotFoundException;
import com.example.HealthBridge.repository.StateRepository;
import com.example.HealthBridge.service.StateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseStateDto createState(StateDto stateDto){
        stateDto.setName(stateDto.getName().toUpperCase());
        stateDto.setDeleted(false);
        try{
            State state = stateRepository.save(objectMapper.convertValue(stateDto,State.class));
            return objectMapper.convertValue(state,ResponseStateDto.class);
        }catch (Exception e){
            throw  new RuntimeException("State already exists !");
        }
    }

    public ResponseStateDto getState(Long id) throws IOException {
        Optional<State> state = stateRepository.findById(id);
        return objectMapper.convertValue(state.get(),ResponseStateDto.class);
    }

    public List<ResponseStateDto> getAllStates(){
        List<ResponseStateDto> stateDtoList = stateRepository.findAll().stream()
                .map(state -> objectMapper.convertValue(state,ResponseStateDto.class))
                .collect(Collectors.toList());
        return stateDtoList;
    }
    public ResponseStateDto updateState(StateDto stateDto,Long id){
        stateDto.setName(stateDto.getName().toUpperCase());
        Optional<State> existingState = Optional.ofNullable(stateRepository.findById(id).orElseThrow(() -> new StateNotFoundException("State with id "+id+" not found.")));
        existingState.get().setName(stateDto.getName());
        existingState.get().setDeleted(false);
        return objectMapper.convertValue(stateRepository.save(existingState.get()), ResponseStateDto.class);
    }

    public void deleteState(Long id){
        State existingState = stateRepository.findById(id).orElseThrow(()-> new StateNotFoundException("State with id "+id+" not found."));
        existingState.setDeleted(true);
        stateRepository.save(existingState);
    }

}
