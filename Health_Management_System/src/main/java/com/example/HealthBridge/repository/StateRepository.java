package com.example.HealthBridge.repository;

import com.example.HealthBridge.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {

    @Query(value = "SELECT * FROM state WHERE state_id = ?1 AND is_deleted = false", nativeQuery = true)
    Optional<State> findById(Long id);

    @Query(value = "SELECT * FROM state WHERE is_deleted = false",nativeQuery = true)
    List<State> findAll();

}
