package com.problemSolvingPlatform.Problem.Solving.Platform.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Boolean isAttempted;

    private String contestName;

    @ElementCollection
    private List<Problem> Problems;

    public boolean isAttempted() {
        return false;
    }
}
