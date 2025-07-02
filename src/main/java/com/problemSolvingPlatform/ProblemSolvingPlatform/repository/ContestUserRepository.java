package com.problemSolvingPlatform.ProblemSolvingPlatform.repository;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.ContestUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestUserRepository extends JpaRepository<ContestUser,Long> {
}
