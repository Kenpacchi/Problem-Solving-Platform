package com.problemSolvingPlatform.ProblemSolvingPlatform.repository;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem,Long> {

    @Query("SELECT p FROM Problem p WHERE p.level = :difficulty")
    List<Problem> findByDifficulty(@Param("difficulty") String difficulty);

    List<Problem> findByIsSolvedFalse();
}
