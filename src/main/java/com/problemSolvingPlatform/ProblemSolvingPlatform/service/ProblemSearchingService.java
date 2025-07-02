package com.problemSolvingPlatform.ProblemSolvingPlatform.service;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Contest;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.User;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.ContestRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.ProblemRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.TopicRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemSearchingService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ContestRepository contestRepository;

    public List<Problem> getProblemByTopicName(String name){
       return topicRepository.findByTopicName(name).getTopicProblems();
    }
    public List<Problem> getProblemsByDifficulty(String difficulty){
        return problemRepository.findByDifficulty(difficulty);
    }
    public List<Problem> getUnsolvedProblems(User user) {
        return problemRepository.findByIsSolvedFalse();
    }

    public List<Contest> getUnattemptedContests(User user) {
        return contestRepository.findByIsAttemptedFalse();
    }

    public List<Contest> getAttemptedContests(User user) {
        return contestRepository.findByIsAttemptedTrue();
    }

}
