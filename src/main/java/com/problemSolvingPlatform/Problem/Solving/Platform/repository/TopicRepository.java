package com.problemSolvingPlatform.Problem.Solving.Platform.repository;

import com.problemSolvingPlatform.Problem.Solving.Platform.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    @Query("SELECT * FROM topic As a WHERE a.name=:name ")
    Topic findByName(String name);
}
