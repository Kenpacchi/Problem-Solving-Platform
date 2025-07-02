package com.problemSolvingPlatform.ProblemSolvingPlatform.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="contest")
@Data
@Getter
@Setter
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
