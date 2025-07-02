package com.problemSolvingPlatform.ProblemSolvingPlatform.service;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.*;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.ContestRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.ProblemRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.TopicRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.UserRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProblemSolvingService {
    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Problem> searchProblemsByTopic(String topicName) {
        Optional<Topic> topicOpt = Optional.ofNullable(topicRepository.findByTopicName(topicName));
        return topicOpt.map(Topic::getTopicProblems).orElse(Collections.emptyList());
    }

    public void solveProblem(Problem problem, User user) {
        problem.setIsSolved(true);
        problemRepository.save(problem);

        switch (problem.getLevel()) {
            case "Easy" -> user.setEasySolved(user.getEasySolved() + 1);
            case "Medium" -> user.setMediumSolved(user.getMediumSolved() + 1);
            case "Hard" -> user.setHardSolved(user.getHardSolved() + 1);
        }

        user.setTotalProblemSolved(user.getTotalProblemSolved() + 1);
        userRepository.save(user);
    }

    public List<Map.Entry<Long, ContestUser>> getContestRanking(List<ContestUser> users) {
        users.sort((a, b) -> {
            if (a.getSolvedProblem() == b.getSolvedProblem()) {
                return Long.compare(a.getTimeTaken(), b.getTimeTaken());
            }
            return Long.compare(b.getSolvedProblem(), a.getSolvedProblem());
        });

        List<Map.Entry<Long, ContestUser>> rankings = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            rankings.add(Map.entry((long) (i + 1), users.get(i)));
        }
        return rankings;
    }

    public void attemptContest(Contest contest, User user) {
        List<Problem> problems = contest.getProblems();
        for (Problem problem : problems) {
            solveProblem(problem, user);
        }
        contest.setIsAttempted(true);
        contestRepository.save(contest);
    }
}
