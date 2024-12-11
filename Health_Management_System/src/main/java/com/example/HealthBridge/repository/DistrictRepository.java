package com.example.HealthBridge.repository;

import com.example.HealthBridge.dto.DistrictDto;
import com.example.HealthBridge.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District,Long> {
    Optional<District> findByName(String name);

    @Query(value = "SELECT * FROM district WHERE state_id = ?1",nativeQuery = true)
    List<District> findAllDistrictsInState(Long id);
}
