package com.problemSolvingPlatform.Problem.Solving.Platform.repository;

import com.problemSolvingPlatform.Problem.Solving.Platform.entity.ContestUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestUserRepository extends JpaRepository<ContestUser,Long> {
}
