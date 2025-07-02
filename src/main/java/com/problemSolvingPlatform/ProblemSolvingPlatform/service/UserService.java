package com.problemSolvingPlatform.ProblemSolvingPlatform.service;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.User;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.TopicRepository;
import com.problemSolvingPlatform.ProblemSolvingPlatform.repository.UserRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TopicRepository topicRepository;
    Long failedCounter=0L;

    public String signUpUser(User user){
        String phoneNumber=user.getPhoneNumber();
        if(userRepository.findByPhoneNumber(phoneNumber)!=null){
            return "User Already Exist Please Login";
        }
        user.setEasySolved(0L);
        user.setHardSolved(0L);
        user.setMediumSolved(0L);
        user.setTotalProblemSolved(0L);
        user.setRating(0L);
        userRepository.save(user);
        return "User Registered Successfully";
    }

    public String loginUser(User user){
        if(Objects.equals(user.getPassword(), userRepository.findByPhoneNumber(user.getPhoneNumber()).getPassword())){
            return "User Login Success !!";
        }
        failedCounter+=1L;
        if(failedCounter>5L){
            return "Try Again After Some Time";
        }
        return loginUser(user);
    }
    private List<Problem> getProblemsByeTopicName(String name){
        return topicRepository.findByName(name).getTopicProblems();
    }
}
