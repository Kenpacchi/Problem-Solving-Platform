package com.problemSolvingPlatform.ProblemSolvingPlatform.repository;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestRepository extends JpaRepository<Contest,Long> {
    List<Contest> findByIsAttemptedFalse();

    List<Contest> findByIsAttemptedTrue();
}
