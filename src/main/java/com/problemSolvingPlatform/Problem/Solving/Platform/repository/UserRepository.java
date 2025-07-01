package com.problemSolvingPlatform.Problem.Solving.Platform.repository;

import com.problemSolvingPlatform.Problem.Solving.Platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT * FROM users AS a WHERE a.phoneNumber=:phoneNumber")
    User findByPhoneNumber(String phoneNumber);
}
