package com.ltfullstack.userservice.service;

import com.ltfullstack.userservice.model.User;
import com.ltfullstack.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Cacheable(value = "allUsers", key = "'all'")
    public List<User> getAllUsers() {
        System.out.println("⏳ Querying DB...");
        return userRepository.findAll();
    }
}
