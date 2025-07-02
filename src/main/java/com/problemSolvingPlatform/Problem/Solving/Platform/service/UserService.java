package com.problemSolvingPlatform.Problem.Solving.Platform.service;

import com.problemSolvingPlatform.Problem.Solving.Platform.entity.*;
import com.problemSolvingPlatform.Problem.Solving.Platform.repository.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Data
@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private ContestRepository contestRepository;


    private Long failedCounter=0L;
    public void checkCredentials(User user){
        String phoneNumber=user.getPhoneNumber();
        User user1=userRepository.findByPhoneNumber(phoneNumber);
        if(user1==null){
            System.out.print("User Found!! Please Login");
            loginUser(user);
            return;
        }
        signUp(user);
    }

    private void signUp(User user) {
        System.out.print("SignUp Success !!");
        user.setEasySolved(0L);
        user.setHardSolved(0L);
        user.setMediumSolved(0L);
        user.setTotalProblemSolved(0L);
        userRepository.save(user);
    }

    private void loginUser(User user){
        String givenPassword=user.getPassword();
        User user1=userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(Objects.equals(user1.getPassword(), givenPassword)){
            System.out.print("Login Success !!");
            return;
        }
        failedCounter+=1L;
        if(failedCounter>5L){
            System.out.print("Please Try Again After Some Time");
            return;
        }
        loginUser(user);
    }

    public List<Problem> searchProblemsByTopicName(String name){
        Topic topic= topicRepository.findByName(name);
        return topic.getTopicProblems();
    }

    public List<Problem> getUnsolvedProblems() {
        return problemRepository.findAll()
                .stream()
                .filter(p -> !p.getIsSolved())
                .collect(Collectors.toList());
    }

    public List<Contest> getUnattemptedContests() {
        return contestRepository.findAll()
                .stream()
                .filter(c -> !c.isAttempted())
                .collect(Collectors.toList());
    }

    public List<Contest> getAttemptedContests() {
        return contestRepository.findAll()
                .stream()
                .filter(Contest::isAttempted)
                .collect(Collectors.toList());
    }

    public void solveProblem(Problem problem,User user){
        problem.setIsSolved(true);
        problemRepository.save(problem);
        user.setTotalProblemSolved(user.getTotalProblemSolved()+1L);
        String level= problem.getLevel();
        if(Objects.equals(level, "Medium")){
            user.setMediumSolved(user.getMediumSolved()+1L);
        }else if(Objects.equals(level, "Hard")){
            user.setHardSolved(user.getHardSolved()+1L);
        }else{
            user.setEasySolved(user.getEasySolved()+1L);
        }
        userRepository.save(user);
    }
    public List<Problem> getProblemByDifficulty(String difficulty){
        return problemRepository.findByDifficulty(difficulty);
    }

    public List<Map.Entry<Integer, ContestUser>> getContestRanking(List<ContestUser> users) {
        users.sort((a, b) -> {
            if (a.getSolvedProblem() == b.getSolvedProblem())
                return Long.compare(a.getTimeTaken(), b.getTimeTaken());
            return Long.compare(b.getSolvedProblem(), a.getSolvedProblem());
        });

        List<Map.Entry<Integer, ContestUser>> rankings = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            rankings.add(Map.entry(i + 1, users.get(i)));
        }
        return rankings;
    }
}
