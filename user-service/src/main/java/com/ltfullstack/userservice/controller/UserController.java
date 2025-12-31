package com.ltfullstack.userservice.controller;

import com.ltfullstack.userservice.UserDto;
import com.ltfullstack.userservice.model.User;
import com.ltfullstack.userservice.repository.UserRepository;
import com.ltfullstack.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping
    @CacheEvict(value = "allUsers", allEntries = true)
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
