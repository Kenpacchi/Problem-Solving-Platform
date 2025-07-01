package com.problemSolvingPlatform.Problem.Solving.Platform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isSolved;

    private String description;

    private String editorial;

    private String level;

    private Long totalAccepted;

    private Long totalSubmissions;

    @ElementCollection
    private List<String> testCases;

}
