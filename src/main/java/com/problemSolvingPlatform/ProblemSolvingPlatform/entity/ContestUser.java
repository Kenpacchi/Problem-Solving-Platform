package com.problemSolvingPlatform.ProblemSolvingPlatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contestUser")
public class ContestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private long solvedProblem;

    private long timeTaken;
}
