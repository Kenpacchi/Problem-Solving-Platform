package com.problemSolvingPlatform.ProblemSolvingPlatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PsUsers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phoneNumber;

    private String password;

    private String email;

    private Long totalProblemSolved;

    private Long EasySolved;

    private Long mediumSolved;

    private Long hardSolved;

    private Long rating;
}
