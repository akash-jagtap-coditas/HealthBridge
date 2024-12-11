package com.example.HealthBridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.HealthBridge.repository")
@EntityScan(basePackages = "com.example.HealthBridge.entity")
public class HealthBridge {

	public static void main(String[] args) {
		SpringApplication.run(HealthBridge.class, args);
	}

}
