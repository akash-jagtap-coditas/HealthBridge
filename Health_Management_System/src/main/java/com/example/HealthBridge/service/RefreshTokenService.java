package com.example.HealthBridge.service;

import com.example.HealthBridge.entity.RefreshToken;

import java.util.Optional;

/**
 * Service interface for managing refresh tokens.
 */
public interface RefreshTokenService {

    /**
     * Finds a refresh token by its token string.
     *
     * @param token the token string
     * @return an optional containing the found refresh token
     */
    public Optional<RefreshToken> findByToken(String token);

    /**
     * Creates a new refresh token for a specific user.
     *
     * @param username the username of the user
     * @return an optional containing the created refresh token
     */
    public Optional<RefreshToken> createRefreshToken(String username);
}
