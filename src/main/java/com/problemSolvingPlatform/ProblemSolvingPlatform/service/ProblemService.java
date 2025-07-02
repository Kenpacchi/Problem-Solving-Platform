package com.problemSolvingPlatform.ProblemSolvingPlatform.service;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.ProblemRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.TopicRepository;
import lombok.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private TopicRepository topicRepository;

    public List<Problem> getProblemByTopicName(String name){
       return topicRepository.findByName(name).getTopicProblems();
    }
    public List<Problem> getProblemsByDifficulty(String difficulty){
        return problemRepository.findByDifficulty(difficulty);
    }
}
