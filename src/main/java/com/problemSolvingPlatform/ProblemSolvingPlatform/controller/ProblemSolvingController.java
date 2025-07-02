package com.problemSolvingPlatform.ProblemSolvingPlatform.controller;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Contest;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.ContestUser;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.User;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.ProblemRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.service.ProblemSolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leetApi/solve")
public class ProblemSolvingController {

    @Autowired
    private ProblemSolvingService problemSolvingService;

    @PostMapping("/solve-problem")
    public String solveProblem(@RequestBody Map<String, Object> payload) {
        Problem problem = (Problem) payload.get("problem");
        User user = (User) payload.get("user");
        problemSolvingService.solveProblem(problem, user);
        return "Problem solved successfully.";
    }

    @PostMapping("/attempt-contest")
    public String attemptContest(@RequestBody Map<String, Object> payload) {
        Contest contest = (Contest) payload.get("contest");
        User user = (User) payload.get("user");
        problemSolvingService.attemptContest(contest, user);
        return "Contest attempted successfully.";
    }

    @PostMapping("/contest-rankings")
    public List<Map.Entry<Long, ContestUser>> getContestRankings(@RequestBody List<ContestUser> users) {
        return problemSolvingService.getContestRanking(users);
    }

}
