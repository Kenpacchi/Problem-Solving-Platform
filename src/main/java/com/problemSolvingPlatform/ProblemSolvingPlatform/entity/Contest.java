package com.problemSolvingPlatform.ProblemSolvingPlatform.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="contest")
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
