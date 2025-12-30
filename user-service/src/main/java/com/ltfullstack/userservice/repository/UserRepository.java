package com.ltfullstack.userservice.repository;

import com.ltfullstack.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
