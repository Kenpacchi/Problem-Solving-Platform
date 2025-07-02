package com.problemSolvingPlatform.ProblemSolvingPlatform.repository;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String phoneNumber);

    User findByName(String name);
}