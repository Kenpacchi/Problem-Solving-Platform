package com.problemSolvingPlatform.ProblemSolvingPlatform.controller;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import com.problemSolvingPlatform.ProblemSolvingPlatform.service.ProblemService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@RequestMapping("/leetApi/prob")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @GetMapping("/getProblemByTopicName")
    public List<Problem> getProblemByTopicName(@PathVariable String name){
        return problemService.getProblemByTopicName(name);
    }

    @GetMapping("/getProblemByDifficulty")
    public List<Problem> getProblemByDifficulty(@PathVariable String difficulty){
        return problemService.getProblemsByDifficulty(difficulty);
    }

};