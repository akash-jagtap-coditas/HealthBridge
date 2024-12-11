package com.example.HealthBridge.service.Impl;

import com.example.HealthBridge.entity.Users;
import com.example.HealthBridge.repository.UserRepository;

import com.example.HealthBridge.config.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service implementation for loading user details by username.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    /**
     * Loads user details by username.
     *
     * @param username the username of the user
     * @return the UserDetails object
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Users user = userRepo.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username " + username);
        }
        return UserDetailsImpl.build(user);
    }
}
