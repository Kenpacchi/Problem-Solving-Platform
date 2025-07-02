package com.problemSolvingPlatform.ProblemSolvingPlatform.repository;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByName(String name);
}