package com.problemSolvingPlatform.ProblemSolvingPlatform.controller;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.User;
import com.problemSolvingPlatform.ProblemSolvingPlatform.service.ProblemSearchingService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leetApi/prob")
public class ProblemSearchingController {
    @Autowired
    private ProblemSearchingService problemSearchingService;

    @GetMapping("/getProblemByTopicName/{name}")
    public List<Problem> getProblemByTopicName(@PathVariable String name){
        return problemSearchingService.getProblemByTopicName(name);
    }

    @GetMapping("/getProblemByDifficulty/{Difficulty}")
    public List<Problem> getProblemByDifficulty(@PathVariable String difficulty){
        return problemSearchingService.getProblemsByDifficulty(difficulty);
    }

    @PostMapping("/unsolved")
    public List<Problem> getUnsolvedProblems(@RequestBody User user) {
        return problemSearchingService.getUnsolvedProblems(user);
    }

    @GetMapping("/by-difficulty")
    public List<Problem> getProblemsByDifficultyQuery(@RequestParam String level) {
        return problemSearchingService.getProblemsByDifficulty(level);
    }

};